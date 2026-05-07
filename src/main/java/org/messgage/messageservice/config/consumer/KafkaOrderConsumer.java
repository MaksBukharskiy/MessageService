package org.messgage.messageservice.config.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.messgage.messageservice.orders.OrderCreateEvent;
import org.messgage.messageservice.service.OrderService;
import org.springframework.kafka.annotation.BackOff;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaOrderConsumer {
    private final OrderService orderService;

    @RetryableTopic(
            attempts = "2",
            backOff = @BackOff(delay = 2000),
            dltTopicSuffix = ".DLT"
    )

    @KafkaListener(
            topics = "orders",
            groupId = "order-group",
            containerFactory = "manualAckKafkaListenerContainerFactory"
    )
    public void listen(OrderCreateEvent event){
        log.info("\n\n🔥 Received from Kafka: {}\n", event);

        orderService.handle(event);
    }

    @KafkaListener(
            topics = "orders.DLT",
            groupId = "order-dlt-group",
            containerFactory = "manualAckKafkaListenerContainerFactory"
    )
    public void listenDeadMessages(OrderCreateEvent event){
        log.info("💀 DLT message received: {}", event);
    }

}

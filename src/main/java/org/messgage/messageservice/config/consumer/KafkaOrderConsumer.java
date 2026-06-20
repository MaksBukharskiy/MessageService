package org.messgage.messageservice.config.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.messgage.messageservice.orders.OrderCreateEvent;
import org.messgage.messageservice.service.OrderService;
import org.springframework.kafka.annotation.BackOff;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.support.Acknowledgment;
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

    public void listen(OrderCreateEvent event, Acknowledgment acknowledgment) {
        try {
            orderService.handle(event);
            acknowledgment.acknowledge();

            log.info("✅ Message acknowledged");
        } catch (Exception e) {
            log.error("❌ Error while processing message: {}", e.getMessage());
            throw e;
        }
    }

    @KafkaListener(
            topics = "orders.DLT",
            groupId = "order-dlt-group",
            containerFactory = "manualAckKafkaListenerContainerFactory"
    )

    public void listenDeadMessages(OrderCreateEvent event, Acknowledgment acknowledgment){
        log.info("💀 DLT message received: {}", event);
        acknowledgment.acknowledge();
    }

}

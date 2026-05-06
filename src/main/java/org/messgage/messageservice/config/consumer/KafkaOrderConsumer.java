package org.messgage.messageservice.config.consumer;

import lombok.extern.slf4j.Slf4j;
import org.messgage.messageservice.orders.OrderCreateEvent;
import org.springframework.kafka.annotation.BackOff;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaOrderConsumer {

    @RetryableTopic(
            attempts = "3",
            backOff = @BackOff(delay = 2000),
            dltTopicSuffix = ".DLT"
    )

    @KafkaListener(topics = "orders", groupId = "order-group")
    public void listen(OrderCreateEvent event){
        log.info("🔥 Received from Kafka: {}", event);

        if ("fail".equals(event.product())) {
            throw new RuntimeException("Test error");
        }
    }

    @KafkaListener(topics = "orders.DLT", groupId = "order-group")
    public void listenDeadMessages(OrderCreateEvent event){
        log.info("💀 DLT message received: {}", event);
    }


}

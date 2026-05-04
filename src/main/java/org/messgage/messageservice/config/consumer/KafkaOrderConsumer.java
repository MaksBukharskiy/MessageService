package org.messgage.messageservice.config.consumer;

import lombok.extern.slf4j.Slf4j;
import org.messgage.messageservice.orders.OrderCreateEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaOrderConsumer {

    @KafkaListener(topics = "orders", groupId = "order-group")
    public void listen(OrderCreateEvent event){
        log.info("\n\n🔥 Received from Kafka: {}", event);
    }
}

package org.messgage.messageservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.messgage.messageservice.JPA.OrderEntity;
import org.messgage.messageservice.JPA.repository.OrderRepository;
import org.messgage.messageservice.orders.OrderCreateEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@AllArgsConstructor
public class OrderService {

        private final OrderRepository repository;
        private final KafkaTemplate<String, OrderCreateEvent> kafkaTemplate;

        public void process(OrderCreateEvent orderCreateEvent){
            OrderEntity entity = new OrderEntity();

            entity.setOrderId(orderCreateEvent.orderId());
            entity.setProduct(orderCreateEvent.product());
            entity.setQuantity(orderCreateEvent.quantity());
            entity.setCreatedAt(LocalDateTime.now());

            repository.save(entity);
            kafkaTemplate.send("orders", orderCreateEvent);

            log.info("\n\n ✅Order saved: {}\n", entity);
        }

        public void handle(OrderCreateEvent event){
            if ("fail".equals(event.product())) {
                throw new RuntimeException("Test error");
            }
        }
}
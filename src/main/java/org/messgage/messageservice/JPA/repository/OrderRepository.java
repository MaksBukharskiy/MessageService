package org.messgage.messageservice.JPA.repository;

import org.messgage.messageservice.JPA.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
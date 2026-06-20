package org.messgage.messageservice.jpa.repository;

import org.messgage.messageservice.jpa.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, String> {
}
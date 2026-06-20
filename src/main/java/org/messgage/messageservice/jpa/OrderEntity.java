package org.messgage.messageservice.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
public class OrderEntity {

    @Id
    private String orderId;

    @Setter
    private String product;

    @Setter
    private Integer quantity;

    private LocalDateTime createdAt;

    public OrderEntity() {
    }

    public OrderEntity(
            String orderId,
            String product,
            Integer quantity,
            LocalDateTime createdAt
    ) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
        this.createdAt = createdAt;
    }
}
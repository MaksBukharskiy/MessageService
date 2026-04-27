package org.messgage.messageservice.orders;

public record Order(
        String orderId,
        String product,
        Integer quantity
) {
}

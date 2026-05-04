package org.messgage.messageservice.orders;

public record OrderCreateEvent(
        String orderId,
        String product,
        Integer quantity
) {
}

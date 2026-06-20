package org.messgage.messageservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.messgage.messageservice.orders.OrderCreateEvent;
import org.messgage.messageservice.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
@Slf4j
public class OrderController{
    private final OrderService orderService;

    @PostMapping
    public void createOrder(@RequestBody OrderCreateEvent orderCreateEvent) {
        orderService.process(orderCreateEvent);
    }
}

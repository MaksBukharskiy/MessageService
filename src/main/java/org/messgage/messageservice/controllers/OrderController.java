package org.messgage.messageservice.controllers;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.messgage.messageservice.orders.Order;
import org.messgage.messageservice.service.OrderService;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
@Slf4j
public class OrderController extends SpringBootServletInitializer {
    private final OrderService orderService;

    @PostMapping
    public void createOrder(@RequestBody Order order) {
        orderService.process(order);
    }
}

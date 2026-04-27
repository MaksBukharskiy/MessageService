package org.messgage.messageservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.messgage.messageservice.orders.Order;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class OrderService {

    public void process(Order order){
        log.info("processing in order: {}", order);
    }
}

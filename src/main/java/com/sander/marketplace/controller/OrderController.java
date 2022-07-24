package com.sander.marketplace.controller;

import com.sander.marketplace.model.Order;
import com.sander.marketplace.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping("/order/{userId}/{productId}")
    public Order save(@PathVariable Long userId,
                      @PathVariable Long productId) {
        Order order = new Order(userId, productId);
        return orderService.save(order, userId, productId);

    }
}

package com.sander.marketplace.service;

import com.sander.marketplace.model.Order;
import com.sander.marketplace.model.User;
import com.sander.marketplace.repository.OrderRepository;
import com.sander.marketplace.repository.ProductRepository;
import com.sander.marketplace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserService userService;


    public Order save(Order order, Long userId, Long productId) {
        if (getUserAmount(userId) >= getProductPrice(productId)) {
            User user = userRepository.findById(userId).get();
            user.setAmountOfMoney(getUserAmount(userId) - getProductPrice(productId));
            userService.addUser(user);
            return orderRepository.save(order);
        }
        throw new RuntimeException("User havn`t enough money for buying this product");
    }

    public long getUserAmount(long id) {
        return userRepository.findById(id).get().getAmountOfMoney();
    }

    public long getProductPrice(long id) {
        return productRepository.findById(id).get().getPrice();
    }
}

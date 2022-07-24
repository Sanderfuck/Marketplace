package com.sander.marketplace.repository;

import com.sander.marketplace.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

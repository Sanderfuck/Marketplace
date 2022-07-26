package com.sander.marketplace.repository;

import com.sander.marketplace.model.Order;
import com.sander.marketplace.model.Product;
import com.sander.marketplace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "SELECT p FROM Product p WHERE p.id IN (SELECT o.productId FROM Order o WHERE o.userId= :id)")
    List<Product> findAllProductsByUserId(@Param("id") Long userId);

    @Query(value = "SELECT u FROM User u WHERE u.id IN (SELECT o.userId FROM Order o WHERE o.productId= :id)")
    List<User> findAllUsersByProductId(@Param("id") Long productId);
}

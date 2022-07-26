package com.sander.marketplace.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(position = 1)
    private Long id;

    @Column(name = "user_id")
    @ApiModelProperty(position = 2)
    private Long userId;

    @Column(name = "product_id")
    @ApiModelProperty(position = 3)
    private Long productId;

    public Order(Long userId, Long productId) {
        this.userId = userId;
        this.productId = productId;
    }
}

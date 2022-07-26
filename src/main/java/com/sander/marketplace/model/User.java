package com.sander.marketplace.model;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(position = 1)
    private Long id;


    @Column(name = "first_name")
    @ApiModelProperty(position = 2)
    private String firstName;

    @Column(name = "last_name")
    @ApiModelProperty(position = 3)
    private String lastName;

    @Column(name = "amount_of_money")
    @ApiModelProperty(position = 4)
    private Long amountOfMoney;

}

package com.firstproject.onlineshop.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private ProductType productType;

    private BigDecimal price;

}

package com.ecommerce.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Product {

    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer quantity;
    private String description;
    private Category category;

    public Product(String name, BigDecimal price, Integer quantity, String description, Category category) {
        this.id = (int) UUID.randomUUID().getLeastSignificantBits();
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.category = category;
    }
}

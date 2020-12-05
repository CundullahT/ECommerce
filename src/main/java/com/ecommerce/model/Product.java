package com.ecommerce.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

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

}

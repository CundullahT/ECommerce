package com.ecommerce.model;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Category {

    private Integer id;
    private String name;
    private String description;

    public Category(String name, String description){
        this.id = (int) UUID.randomUUID().getLeastSignificantBits();
        this.name = name;
        this.description = description;
    }

}

package com.ecommerce.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("category")
public class CategoryController {

    @GetMapping("/list")
    public String list(){



        return "";

    }

}

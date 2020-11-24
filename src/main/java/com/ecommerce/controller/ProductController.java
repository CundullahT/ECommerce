package com.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("product")
public class ProductController {

    @GetMapping("/{id}")
    public String getProduct(@PathVariable("id") Integer id){

        return "/product/productDetails";

    }

    @GetMapping("/list")
    public String getProductList(){

        return "/product/productList";

    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") Integer id){

        return "/product/productEdit";

    }

    @GetMapping("/add")
    public String createProduct(){

        return "/product/productAdd";

    }

}

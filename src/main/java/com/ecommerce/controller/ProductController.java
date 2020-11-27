package com.ecommerce.controller;

import com.ecommerce.dao.ProductDAO;
import com.ecommerce.datagenerator.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("product")
public class ProductController {

    @GetMapping("/list/details/{id}")
    public String getProduct(@PathVariable("id") Integer id, ProductDAO productDAO, Model model){

        model.addAttribute("product", productDAO.readByID(id));

        return "/product/productDetails";

    }

    @GetMapping("/list")
    public String getProductList(Model model){

        model.addAttribute("products", DataGenerator.getProductList());

        return "/product/productList";

    }

    @GetMapping("/list/details/edit/{id}")
    public String editProduct(@PathVariable("id") Integer id){

        return "/product/productEdit";

    }

    @GetMapping("/add")
    public String createProduct(){

        return "/product/productAdd";

    }

}

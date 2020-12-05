package com.ecommerce.controller;

import com.ecommerce.dao.CategoriesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("category")
public class CategoryController {

    @Autowired
    CategoriesDAO categoriesDAO;

    @GetMapping("/list")
    public String list(Model model) {

        model.addAttribute("categories", categoriesDAO.readAll());

        return "/category/categoryList";

    }

    @GetMapping("/add")
    public String createCategory(){

        return "/category/categoryAdd";
    }

}

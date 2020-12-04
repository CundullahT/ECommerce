package com.ecommerce.controller;

import com.ecommerce.dao.CategoriesDAO;
import com.ecommerce.dao.ProductDAO;
import com.ecommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductDAO productDAO;

    @Autowired
    CategoriesDAO categoriesDAO;

    @GetMapping("/details/{id}")
    public String getProduct(@PathVariable("id") Integer id, Model model){

        model.addAttribute("product", productDAO.readByID(id));

        return "/product/productDetails";

    }

    @GetMapping("/list")
    public String getProductList(Model model){

        model.addAttribute("products", productDAO.readAll());

        return "/product/productList";

    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") Integer id, Model model){

        model.addAttribute("categories", categoriesDAO.readAll());
        model.addAttribute("product", productDAO.readByID(id));

        return "/product/productForm";

    }

    @PostMapping("/edit/{id}")
    public String updateProduct(@PathVariable("id") Integer id, @ModelAttribute("product") Product product, Model model) throws Exception {
        productDAO.update(product,id);
        return "redirect:/product/productList";

    }

    @GetMapping("/add")
    public String createProduct(){

        return "/product/productAdd";

    }

    @PostMapping("/add")
    public String insertTask(@ModelAttribute("product") Product product){
        productDAO.create(product);
        return "redirect:/product/list";
    }

}

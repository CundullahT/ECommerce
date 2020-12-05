package com.ecommerce.controller;

import com.ecommerce.dao.CategoriesDAO;
import com.ecommerce.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("category")
public class CategoryController {

    private final CategoriesDAO categoriesDAO;

    @Autowired
    public CategoryController(CategoriesDAO categoriesDAO){
        this.categoriesDAO = categoriesDAO;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("categories", categoriesDAO.readAll());
        return "/category/categoryList";
    }

    @GetMapping("/add")
    public String createCategory(Model model){
        model.addAttribute("category", new Category());
        return "/category/categoryAdd";
    }

    @PostMapping("/add")
    public String insertCategory(@ModelAttribute Category category){
        categoriesDAO.create(category.getId(), category);
        return "redirect:/category/list";
    }

    @GetMapping("/details/{id}")
    public String getCategory(@PathVariable("id") Integer id, Model model){
        model.addAttribute("category", categoriesDAO.readByID(id));
        return "/category/categoryDetails";
    }

    @GetMapping("/edit/{id}")
    public String editCategory(@PathVariable("id") Integer id, Model model){
        model.addAttribute("category", categoriesDAO.readByID(id));
        return "/category/categoryForm";
    }

    @PostMapping("/edit/{id}")
    public String updateCategory(@PathVariable("id") Integer id, @ModelAttribute("category") Category category) throws Exception {
        categoriesDAO.update(id, category);
        return "redirect:/category/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id){
        categoriesDAO.delete(categoriesDAO.readByID(id));
        return "redirect:/category/list";
    }

}

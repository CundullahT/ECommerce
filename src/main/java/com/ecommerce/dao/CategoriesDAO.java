package com.ecommerce.dao;

import com.ecommerce.datagenerator.DataGenerator;
import com.ecommerce.model.Category;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriesDAO {

    private List<Category> categoryList = DataGenerator.getCategoryList();

    public void create(Category category) {

        Optional<Category> lastCat = categoryList.stream().sorted(Comparator.comparing(Category::getId)).collect(Collectors.toList()).stream().reduce((a, b) -> b);

        if (lastCat.isPresent()) {
            category.setId(lastCat.get().getId() + 1);
        } else {
            category.setId(1);
        }

        categoryList.add(category);

    }

    public List<Category> readAll() {
        return categoryList;
    }

    public Category readByID(Integer id) {
        return categoryList.stream().filter(category -> category.getId().equals(id)).findFirst().orElse(null);
    }

    public void update(Category category, Integer id) throws Exception {

        if (readByID(id) == null) {
            throw new Exception("No Such Category");
        }

        Category foundedCategory = readByID(category.getId());

        category.setName(foundedCategory.getName());
        category.setDescription(foundedCategory.getDescription());

    }

    public void delete(Category category) {
        categoryList.remove(category);
    }

    public void deleteByID(Integer id) {
        categoryList.removeIf(category -> category.getId().equals(id));
    }

}

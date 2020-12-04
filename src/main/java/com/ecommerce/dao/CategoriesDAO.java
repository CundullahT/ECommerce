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

    public void create(Category category) {

        Optional<Category> lastCat = DataGenerator.getCategoryList().stream().sorted(Comparator.comparing(Category::getId)).collect(Collectors.toList()).stream().reduce((a, b) -> b);

        if (lastCat.isPresent()) {
            category.setId(lastCat.get().getId() + 1);
        } else {
            category.setId(1);
        }

        DataGenerator.getCategoryList().add(category);

    }

    public List<Category> readAll() {
        return DataGenerator.getCategoryList();
    }

    public Category readByID(Integer id) {
        return DataGenerator.getCategoryList().stream().filter(category -> category.getId().equals(id)).findFirst().orElse(null);
    }

    public void update(Category category, Integer id) throws Exception {

        if (readByID(id) == null){
            throw new Exception("No Such Category");
        }

        DataGenerator.getCategoryList().forEach(theCategory -> {
            if(theCategory.getId().equals(id)){
                theCategory.setName(category.getName());
                theCategory.setDescription(category.getDescription());
            }
        });

    }

    public void delete(Category category){
        DataGenerator.getCategoryList().remove(category);
    }

    public void deleteByID(Integer id) {
        DataGenerator.getCategoryList().removeIf(category -> category.getId().equals(id));
    }

}

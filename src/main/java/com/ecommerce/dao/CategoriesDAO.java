package com.ecommerce.dao;

import com.ecommerce.model.Category;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@Service
public class CategoriesDAO extends MapService<Category, Integer> {

    public void create(Integer id, Category category) {

        if(id == null){
            id = (int) UUID.randomUUID().getLeastSignificantBits();
        }

        super.create(id, category);

    }

    public List<Category> readAll() {

        List<Category> categories = super.readAll();

        categories.sort(Comparator.comparing(Category::getName));

        return categories;
    }

    public Category readByID(Integer id) {
        return super.readByID(id);
    }

    public void update(Integer id, Category category) throws Exception {

        if (readByID(id) == null) {
            throw new Exception("No Such Category");
        }

        super.update(id, category);

    }

    public void delete(Category category) {
        super.delete(category);
    }

    public void deleteByID(Integer id) {
        super.deleteByID(id);
    }

}

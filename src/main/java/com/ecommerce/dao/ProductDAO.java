package com.ecommerce.dao;

import com.ecommerce.model.Product;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@Service
public class ProductDAO extends MapService<Product, Integer> {

    public void create(Integer id, Product product) {

        if(id == null){
            id = (int) UUID.randomUUID().getLeastSignificantBits();
        }

        product.setId(id);

        super.create(product.getId(), product);

    }

    public List<Product> readAll() {

        List<Product> products = super.readAll();

        products.sort(Comparator.comparing(Product::getName));

        return products;
    }

    public Product readByID(Integer id) {
        return super.readByID(id);
    }

    public void update(Integer id, Product product) throws Exception {

        if (readByID(id) == null) {
            throw new Exception("No Such Category");
        }

        super.update(id, product);

    }

    public void delete(Product product) {
        super.delete(product);
    }

    public void deleteByID(Integer id) {
        super.deleteByID(id);
    }

}

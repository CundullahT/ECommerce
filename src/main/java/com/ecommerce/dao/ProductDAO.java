package com.ecommerce.dao;

import com.ecommerce.datagenerator.DataGenerator;
import com.ecommerce.model.Product;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductDAO {

    public void create(Product product) {
        Optional<Product> lastProduct = DataGenerator.getProductList().stream().sorted(Comparator.comparing(Product::getId)).collect(Collectors.toList()).stream().reduce((a, b) -> b);

        if (lastProduct.isPresent()) {
            product.setId(lastProduct.get().getId() + 1);
        } else {
            product.setId(1);
        }

        DataGenerator.getProductList().add(product);
    }

    public List<Product> readAll() {
        return DataGenerator.getProductList();
    }

    public Product readByID(Integer id) {
        return DataGenerator.getProductList().stream().filter(product -> product.getId().equals(id)).findFirst().orElse(null);
    }

    public void update(Product product, Integer id) throws Exception {
        if (readByID(id) == null) {
            throw new Exception("No Such Product");
        }

        DataGenerator.getProductList().forEach(theProduct -> {
            if (theProduct.getId().equals(id)) {
                theProduct.setName(product.getName());
                theProduct.setPrice(product.getPrice());
                theProduct.setQuantity(product.getQuantity());
                theProduct.setDescription(product.getDescription());
                theProduct.setCategory(product.getCategory());
            }
        });

    }

    public void delete(Product product) {
        DataGenerator.getProductList().remove(product);
    }

    public void deleteByID(Integer id) {
        DataGenerator.getProductList().removeIf(product -> product.getId().equals(id));
    }

}

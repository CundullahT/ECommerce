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

    private List<Product> productList = DataGenerator.getProductList();

    public void create(Product product) {
        Optional<Product> lastProduct = productList.stream().sorted(Comparator.comparing(Product::getId)).collect(Collectors.toList()).stream().reduce((a, b) -> b);

        if (lastProduct.isPresent()) {
            product.setId(lastProduct.get().getId() + 1);
        } else {
            product.setId(1);
        }

        productList.add(product);
    }

    public List<Product> readAll() {
        return productList;
    }

    public Product readByID(Integer id) {
        return productList.stream().filter(product -> product.getId().equals(id)).findFirst().orElse(null);
    }

    public void update(Product product, Integer id) throws Exception {
        if (readByID(id) == null) {
            throw new Exception("No Such Product");
        }

        Product foundedProduct = readByID(product.getId());

        product.setName(foundedProduct.getName());
        product.setPrice(foundedProduct.getPrice());
        product.setQuantity(foundedProduct.getQuantity());
        product.setDescription(foundedProduct.getDescription());
        product.setCategory(foundedProduct.getCategory());

        productList.remove((int)foundedProduct.getId());
        productList.add(product);

    }

    public void delete(Product product) {
        productList.remove(product);
    }

    public void deleteByID(Integer id) {
        productList.removeIf(product -> product.getId().equals(id));
    }

}

package com.ecommerce.datagenerator;

import com.ecommerce.dao.CategoriesDAO;
import com.ecommerce.dao.ProductDAO;
import com.ecommerce.model.Category;
import com.ecommerce.model.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataGenerator implements CommandLineRunner {

    CategoriesDAO categories;
    ProductDAO products;

    public DataGenerator(ProductDAO products, CategoriesDAO categories){
        this.products = products;
        this.categories = categories;
    }

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category("Cell Phones & Accessories", "Any Description About Cell Phones Accessories");
        Category cat2 = new Category("DVDs & Movies", "Any Description About DVDs & Movies");
        Category cat3 = new Category("Musical Instruments & Gear", "Any Description About Musical Instruments & Gear");
        Category cat4 = new Category("Sporting Goods", "Any Description About Sporting Goods");
        Category cat5 = new Category("Video Games & Consoles", "Any Description About Video Games & Consoles");

        categories.create(cat1.getId(), cat1);
        categories.create(cat2.getId(), cat2);
        categories.create(cat3.getId(), cat3);
        categories.create(cat4.getId(), cat4);
        categories.create(cat5.getId(), cat5);

        Product product1 = new Product("Samsung S9", new BigDecimal("899.99"), 150, "Any Description About Samsung S9", cat1);
        Product product2 = new Product("The Lord Of The Rings The Return Of The King", new BigDecimal("19.99"), 200, "Any Description About The Lord Of The Rings The Return Of The King", cat2);
        Product product3 = new Product("Yamaha Drum Set", new BigDecimal("699.99"), 15, "Any Description About Yamaha Drum Set", cat3);
        Product product4 = new Product("BMW E-Bike", new BigDecimal("3499.99"), 5, "Any Description About BMW E-Bike", cat4);
        Product product5 = new Product("Sony Playstation 5", new BigDecimal("499.99"), 50, "Any Description About Sony Playstation 5", cat5);

        products.create(product1.getId(), product1);
        products.create(product2.getId(), product2);
        products.create(product3.getId(), product3);
        products.create(product4.getId(), product4);
        products.create(product5.getId(), product5);

    }

}

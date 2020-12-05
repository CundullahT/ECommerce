package com.ecommerce.datagenerator;

import com.ecommerce.model.Category;
import com.ecommerce.model.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataGenerator {

    public static List<Product> productList = new ArrayList<>();

    public static List<Category> categories = new ArrayList<>();

    static {

        Category cat1 = new Category(1, "Cell Phones & Accessories", "Any Description About Cell Phones Accessories");
        Category cat2 = new Category(2, "DVDs & Movies", "Any Description About DVDs & Movies");
        Category cat3 = new Category(3, "Musical Instruments & Gear", "Any Description About Musical Instruments & Gear");
        Category cat4 = new Category(4, "Sporting Goods", "Any Description About Sporting Goods");
        Category cat5 = new Category(5, "Video Games & Consoles", "Any Description About Video Games & Consoles");

        categories.addAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5));

        productList.add(new Product(1, "Samsung S9", new BigDecimal("899.99"), 150, "Any Description About Samsung S9", cat1));
        productList.add(new Product(2, "The Lord Of The Rings The Return Of The King", new BigDecimal("19.99"), 200, "Any Description About The Lord Of The Rings The Return Of The King", cat2));
        productList.add(new Product(3, "Yamaha Drum Set", new BigDecimal("699.99"), 15, "Any Description About Yamaha Drum Set", cat3));
        productList.add(new Product(4, "BMW E-Bike", new BigDecimal("3499.99"), 5, "Any Description About BMW E-Bike", cat4));
        productList.add(new Product(5, "Sony Playstation 5", new BigDecimal("499.99"), 50, "Any Description About Sony Playstation 5", cat5));
    }

    public static List<Product> getProductList(){
        return productList;
    }

    public static List<Category> getCategoryList(){
        return categories;
    }

}

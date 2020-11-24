package com.ecommerce.datagenerator;

import com.ecommerce.dao.CategoriesDAO;
import com.ecommerce.model.Category;
import com.ecommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataGenerator {

    public static List<Product> productList = new ArrayList<>();

    public static List<Category> categories = new ArrayList<>();

    @Autowired
    public static CategoriesDAO categoriesDAO;

    static {
        categories.add(new Category(1, "Cell Phones & Accessories", "Any Description About Cell Phones Accessories"));
        categories.add(new Category(2, "DVDs & Movies", "Any Description About DVDs & Movies"));
        categories.add(new Category(3, "Musical Instruments & Gear", "Any Description About Musical Instruments & Gear"));
        categories.add(new Category(4, "Sporting Goods", "Any Description About Sporting Goods"));
        categories.add(new Category(5, "Video Games & Consoles", "Any Description About Video Games & Consoles"));

        productList.add(new Product(1, "Samsung S9", new BigDecimal("899.99"), 150, "Any Description About Samsung S9", categoriesDAO.readByID(1)));
        productList.add(new Product(2, "The Lord Of The Rings The Return Of The King", new BigDecimal("19.99"), 200, "Any Description About The Lord Of The Rings The Return Of The King", categoriesDAO.readByID(2)));
        productList.add(new Product(3, "Yamaha Drum Set", new BigDecimal("699.99"), 15, "Any Description About Yamaha Drum Set", categoriesDAO.readByID(3)));
        productList.add(new Product(4, "BMW E-Bike", new BigDecimal("3499.99"), 5, "Any Description About BMW E-Bike", categoriesDAO.readByID(4)));
        productList.add(new Product(5, "Sony Playstation 5", new BigDecimal("499.99"), 50, "Any Description About Sony Playstation 5", categoriesDAO.readByID(5)));
    }

    public static List<Product> getProductList(){
        return productList;
    }

    public static List<Category> getCategoryList(){
        return categories;
    }

}

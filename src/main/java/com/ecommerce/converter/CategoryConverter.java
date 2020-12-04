package com.ecommerce.converter;

import com.ecommerce.dao.CategoriesDAO;
import com.ecommerce.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class CategoryConverter implements Converter<String, Category> {

    @Autowired
    CategoriesDAO categoriesDAO;

    @Override
    public Category convert(String source) {
        return categoriesDAO.readByID(Integer.parseInt(source));
    }

}

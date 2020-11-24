package com.ecommerce.service;

import java.util.List;

public interface CrudService<T> {

    void create(T t);
    List<T> readAll();
    T readByID(Integer id);
    void update(T t, Integer id) throws Exception;
    void delete(T t);
    void deleteByID(Integer id);

}

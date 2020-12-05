package com.ecommerce.dao;

import java.util.*;

public abstract class MapService<T, ID> {

    protected Map<ID, T> map = new HashMap<>();

    void create(ID id, T t){

        map.put(id, t);

    }

    List<T> readAll(){
        return new ArrayList<>(map.values());
    }

    T readByID(ID id){
        return map.get(id);
    }

    void deleteByID(ID id){
        map.remove(id);
    }

    void delete(T t){
        map.entrySet().removeIf(entry -> entry.getValue().equals(t));
    }

    void update(ID id, T t) throws Exception {
        map.put(id, t);
    }

}

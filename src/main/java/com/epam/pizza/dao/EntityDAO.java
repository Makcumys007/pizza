package com.epam.pizza.dao;

import java.util.List;

public interface EntityDAO<T> {

    List<T> selectAll();
    T selectById(int id);
    int insertEntity(T t);


}

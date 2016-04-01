package com.epam.pizza.dao;

import com.epam.pizza.service.exception.ServiceException;

import java.util.List;

public interface EntityDAO<T> {

    List<T> selectAll();
    T selectById(int id);
    int insertEntity(T t);
    T findByEntity(T t);


}

package com.epam.pizza.dao;

import com.epam.pizza.connection.PizzaConnection;
import com.epam.pizza.entity.User;

import java.sql.Connection;
import java.util.List;

public class UserDAO implements EntityDAO<User> {
    private Connection connection = PizzaConnection.getConnection();
    private final String INSERT_USER = "INSERT INTO (login, password, email) VALUES (?, ?, ?)";

    @Override
    public List<User> selectAll() {
        //TODO
        return null;
    }

    @Override
    public User selectById(int id) {
        return null;
    }

    @Override
    public int insertEntity(User user) {

        return 0;
    }


}

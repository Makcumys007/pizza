package com.epam.pizza.dao;

import com.epam.pizza.connection.PizzaConnection;
import com.epam.pizza.entity.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderDAO implements EntityDAO<Order> {
    private String INSERT_ORDER = "INSERT INTO `pizza`.`order`(`user_id`,`address`,`description`,`count`)VALUES(?,?,?,?)";
    private Connection connection;

    public OrderDAO() {
       connection = PizzaConnection.getConnection();
    }

    @Override
    public List<Order> selectAll() {

        return null;
    }

    @Override
    public Order selectById(int id) {
        return null;
    }

    @Override
    public void insertEntity(Order order) {
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_ORDER);
            ps.setInt(1, order.getUser().getId());
            ps.setString(2, order.getAddress().toString());
            ps.setString(3, order.toString());
            ps.setInt(4, order.getSize());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw  new RuntimeException("SQL error: " + e);
        }
    }

    @Override
    public Order findByEntity(Order order) {
        return null;
    }

    @Override
    public void updateEntity(Order order) {

    }

    @Override
    public void deleteEntity(int id) {

    }

    @Override
    public void close() {
        PizzaConnection.getConnection();
    }
}

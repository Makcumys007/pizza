package com.epam.pizza.dao;

import com.epam.pizza.connection.PizzaConnection;
import com.epam.pizza.entity.Address;
import com.epam.pizza.entity.Order;
import com.epam.pizza.entity.User;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class OrderDAO {
    private  String SELECT_ALL = "SELECT * FROM `pizza`.`order`";
    private String INSERT_ORDER = "INSERT INTO `pizza`.`order`(`user_id`,`address`,`description`,`count`, `date`)VALUES(?,?,?,?,?)";
    private String SELECT_BY_ID = "SELECT * FROM `pizza`.`order` WHERE user_id = ";
    private Connection connection;

    public OrderDAO() {
       connection = PizzaConnection.getConnection();
    }


    public List<Order> selectById(int id) {
        List<Order> orders = new ArrayList<>();
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(SELECT_BY_ID + id);) {

            while (rs.next()) {
                Order order = new Order();
                order.setDescription(rs.getString("description"));
                order.setSize(rs.getInt("count"));
                order.setDate(rs.getDate("date"));
                orders.add(order);
            }
        } catch (SQLException e) {
            throw new RuntimeException("SQL error: " + e);
        }
        return orders;
    }

    public List<Order> selectAll() {
        List<Order> orders = new ArrayList<>();
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(SELECT_ALL);) {

            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setUser(new User(rs.getInt("user_id")));

                String[] adr = rs.getString("address").split(" ");
                Address address = new Address();
                address.setAddressee(adr[0]);
                address.setStreet(adr[1]);
                address.setHouseNumber(Integer.parseInt(adr[2]));
                address.setFlatNumber(Integer.parseInt(adr[3]));
                address.setPhone(adr[4]);
                order.setAddress(address);

                order.setDate(rs.getDate("date"));
                order.setDescription(rs.getString("description"));
                order.setSize(rs.getInt("count"));
                orders.add(order);
            }
        } catch (SQLException e) {
            throw new RuntimeException("SQL error: " + e);
        }
        return orders;
    }


    public void insertEntity(Order order) {
        try (PreparedStatement ps = connection.prepareStatement(INSERT_ORDER);) {
            ps.setInt(1, order.getUser().getId());
            ps.setString(2, order.getAddress().toString());
            ps.setString(3, order.toString());
            ps.setInt(4, order.getSize());
            ps.setDate(5, order.getDate());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw  new RuntimeException("SQL error: " + e);
        }
    }



    public void close() {
        PizzaConnection.closeConnection(connection);
    }
}

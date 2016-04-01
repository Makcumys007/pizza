package com.epam.pizza.dao;

import com.epam.pizza.connection.PizzaConnection;
import com.epam.pizza.entity.User;
import com.epam.pizza.service.exception.ServiceException;

import java.sql.*;
import java.util.List;

public class UserDAO implements EntityDAO<User> {
    private Connection connection = PizzaConnection.getConnection();
    private final String INSERT_USER = "INSERT INTO user(login, password, email, user_role) VALUES (?, ?, ?, ?)";
    private final String UPDATE_USER = "update user set password=?, email=?, user_role=(select id FROM user_role WHERE role=?) where id = ?";
    private final String FIND_USER = "select u.id, u.login, u.password, u.email, ur.role from user u inner" +
            " join user_role ur where ur.id = u.user_role AND u.login like ?";


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
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(INSERT_USER);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setInt(4, 2);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException("SQL error: " + e);
        } finally {
            PizzaConnection.closeStatement(preparedStatement);
            PizzaConnection.closeConnection(connection);
        }
        // TODO
        return 0;
    }

    @Override
    public User findByEntity(User user) {
        User result = new User();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(FIND_USER);
            preparedStatement.setString(1, user.getLogin());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result.setId(resultSet.getInt("id"));
                result.setLogin(resultSet.getString("login"));
                result.setPassword(resultSet.getString("password"));
                result.setEmail(resultSet.getString("email"));
                result.setRole(resultSet.getString("role"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("SQL error: " + e);
        } finally {
            PizzaConnection.closeResultSet(resultSet);
            PizzaConnection.closeStatement(preparedStatement);
            PizzaConnection.closeConnection(connection);
        }

        return result;
    }

    @Override
    public void updateEntity(User user) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(UPDATE_USER);
            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getRole());
            preparedStatement.setInt(4, user.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException("SQL error: " + e);
        } finally {
            PizzaConnection.closeStatement(preparedStatement);
            PizzaConnection.closeConnection(connection);
        }
    }


}

package com.epam.pizza.dao;

import com.epam.pizza.connection.PizzaConnection;
import com.epam.pizza.entity.Product;
import com.epam.pizza.entity.User;
import org.joda.money.Money;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements EntityDAO<Product> {
    private final String locale;
    private String SELECT_ALL_PRODUCT = "SELECT * FROM product";

    private Connection connection = PizzaConnection.getConnection();

    public ProductDAO(String locale) {
        this.locale = locale;
    }

    @Override
    public List<Product> selectAll() {
        List<Product> products = new ArrayList<>();

        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(SELECT_ALL_PRODUCT)) {
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setTitle(rs.getString("title_" + locale));
                product.setDescription(rs.getString("description_" + locale));
                product.setPrice(Money.parse("KZT "+ rs.getString("price")));
                product.setImg(rs.getString("img"));
                product.setType(Product.Type.valueOf(rs.getString("type")));
                products.add(product);
            }

        } catch (SQLException e) {
            throw new RuntimeException("SQL error: " + e);
        } finally {
            PizzaConnection.closeConnection(connection);
        }
        return products;
    }

    @Override
    public Product selectById(int id) {
        // TODO
        return null;
    }

    @Override
    public void insertEntity(Product product) {
        // TODO
    }

    @Override
    public Product findByEntity(Product product) {
        return null;
    }

    @Override
    public void updateEntity(User user) {

    }
}

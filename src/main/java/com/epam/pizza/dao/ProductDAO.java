package com.epam.pizza.dao;

import com.epam.pizza.connection.PizzaConnection;
import com.epam.pizza.entity.Product;
import org.joda.money.Money;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements EntityDAO<Product> {
    private String SELECT_ALL_PRODUCT = "SELECT * FROM product";

    private Connection connection = PizzaConnection.getConnection();

    @Override
    public List<Product> selectAll() {
        List<Product> products = new ArrayList<>();

        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(SELECT_ALL_PRODUCT)) {
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setTitle(rs.getString("title"));
                product.setDescription(rs.getString("description"));
                product.setPrice(Money.parse("KZT "+ rs.getString("price")));
                product.setImg(rs.getString("img"));
                product.setType(Product.Type.valueOf(rs.getString("type")));
                products.add(product);
            }

        } catch (SQLException e) {
            throw new RuntimeException("SQL error: " + e);
        } finally {
            PizzaConnection.close(connection);
        }
        return products;
    }

    @Override
    public Product selectById(int id) {
        // TODO
        return null;
    }

    @Override
    public int insertEntity(Product product) {
        // TODO
        return 0;
    }
}
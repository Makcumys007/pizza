package com.epam.pizza.dao;

import com.epam.pizza.connection.PizzaConnection;
import com.epam.pizza.entity.Product;
import com.epam.pizza.entity.User;
import org.joda.money.Money;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements EntityDAO<Product> {
    private String locale;
    private final String SELECT_ALL_PRODUCT = "SELECT * FROM product";
    private final String DELETE_PRODUCT = "DELETE FROM product WHERE id = ?";
    private final String INSERT_PRODUCT = "INSERT INTO product(title_ru_RU, title_en_US, description_ru_RU, description_en_US, price, type, img) VALUES (?,?,?,?,?,?,?)";
    private InputStream img;
    private Connection connection = PizzaConnection.getConnection();

    public ProductDAO() {
    }

    public ProductDAO(InputStream img) {
        this.img = img;
    }

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
    public void insertEntity(Product product) {
        String[] titles = product.getTitle().split(" <<<>>> ");
        String[] desc = product.getDescription().split(" <<<>>> ");
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(INSERT_PRODUCT);
            ps.setString(1, titles[0]);
            ps.setString(2, titles[1]);
            ps.setString(3, desc[0]);
            ps.setString(4, desc[1]);
            ps.setString(5, product.getPrice0());
            ps.setString(6, product.getType().toString());
            ps.setBinaryStream(7, img);
            ps.execute();

        } catch (SQLException e) {
// TODO обработчик исключения повешай!!!
        } finally {
            PizzaConnection.closeStatement(ps);
        }
    }

    @Override
    public Product selectById(int id) {
        // TODO
        return null;
    }

    @Override
    public Product findByEntity(Product product) {
        return null;
    }

    @Override
    public void updateEntity(User user) {

    }

    @Override
    public void deleteEntity(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(DELETE_PRODUCT);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException("SQL error: " + e);
        } finally {
            PizzaConnection.closeStatement(statement);
            PizzaConnection.closeConnection(connection);
        }
    }
}

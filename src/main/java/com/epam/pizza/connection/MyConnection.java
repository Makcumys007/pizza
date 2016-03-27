package com.epam.pizza.connection;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class MyConnection {
    public static Connection getConnection() {
        Connection conn;
        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/testdb");
            conn = ds.getConnection();
        } catch (NamingException e) {
            throw new RuntimeException("Naming context error: " + e);
        } catch (SQLException e) {
            throw new RuntimeException("SQL connection error: " + e);
        }
        return conn;
    }
}

package com.epam.pizza.dao;

import com.epam.pizza.connection.PizzaConnection;
import com.epam.pizza.entity.BaseEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BankAccount extends BaseEntity{

    private String number;
    private String time;
    private String cvv;

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private Connection connection = PizzaConnection.getConnection();

    public BankAccount findBankAccountAccount(BankAccount account) {
        BankAccount res = new BankAccount();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM bank WHERE number = " + account.number);
            while (rs.next()) {
                res.setId(rs.getInt("id"));
                res.setNumber(rs.getString("number"));
                res.setTime(rs.getString("time"));
                res.setCvv(rs.getString("cvv"));
            }
        } catch (SQLException e) {
            throw  new RuntimeException("SQL error:" + e);
        }
        return res;
    }

}

package com.epam.pizza.dao;

import com.epam.pizza.connection.PizzaConnection;
import com.epam.pizza.entity.BaseEntity;
import org.joda.money.Money;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BankAccount extends BaseEntity{

    private String number;
    private String time;
    private String cvv;
    private Money money;

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

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
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
                res.setMoney(Money.parse("KZT " + rs.getString("money")));
            }
        } catch (SQLException e) {
            throw  new RuntimeException("SQL error:" + e);
        }
        return res;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        BankAccount that = (BankAccount) o;

        if (!number.equals(that.number)) return false;
        if (!time.equals(that.time)) return false;
        return cvv.equals(that.cvv);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + number.hashCode();
        result = 31 * result + time.hashCode();
        result = 31 * result + cvv.hashCode();
        return result;
    }


}

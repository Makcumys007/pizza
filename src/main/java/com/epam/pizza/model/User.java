package com.epam.pizza.model;

/**
 * Created by advirtys on 16.02.16.
 */
public class User extends BaseEntity{
    private String login;
    private String password;
    private String email;
    private Address address;

    public User() {
    }

    public User(Address address) {
        this.address = address;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

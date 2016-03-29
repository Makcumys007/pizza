package com.epam.pizza.entity;

public class User extends BaseEntity{
    private Role group;
    private String login;
    private String password;
    private String email;


    public User() {
    }

    public User(Role group) {
        this.group = group;
    }

    public Role getGroup() {
        return group;
    }

    public void setGroup(Role group) {
        this.group = group;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        isNull(login);
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        isNull(password);
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        isNull(email);
        this.email = email;
    }



}

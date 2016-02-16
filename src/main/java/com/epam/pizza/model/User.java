package com.epam.pizza.model;

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

}

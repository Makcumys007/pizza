package com.epam.pizza.model;

import org.joda.money.Money;


public class Pizza extends BaseEntity {
    private String title;
    private String description;
    private Money money;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Pizza title=" + title +
                ", description=" + description +
                ", money=" + money.getAmount().toString()
                ;
    }
}

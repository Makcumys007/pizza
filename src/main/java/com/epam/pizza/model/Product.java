package com.epam.pizza.model;

import org.joda.money.Money;

public class Product extends BaseEntity {
    private String title;
    private String description;
    private Money price;

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

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product title=" + title +
                ", description=" + description +
                ", price=" + price.getAmount().toString()
                ;
    }
}

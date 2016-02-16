package com.epam.pizza.model;

import org.joda.money.Money;
import java.util.ArrayList;
import java.util.List;

public class Order extends BaseEntity{

    private User user;
    private List<Pizza> pizzas;
    private Money price = Money.parse("KZT 0.00");

    public Order() {
        if (pizzas == null) {
            pizzas = new ArrayList<Pizza>();
        }
    }

    public Order(User user) {
        this.user = user;
        if (pizzas == null) {
            pizzas = new ArrayList<Pizza>();
        }
    }

    public boolean add(Pizza pizza) {
        price = price.plus(pizza.getMoney());
        return pizzas.add(pizza);
    }

    public void remove() {
        if (pizzas != null) {
            pizzas = new ArrayList<Pizza>();
        }
    }

    public int getCount() {
        return pizzas.size();
    }

    public Money getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Order" +
                " user=" + user.getLogin() +
                " count=" + getCount() +
                " price=" + getPrice();
    }
}

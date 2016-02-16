package com.epam.pizza.model;

import org.joda.money.Money;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by advirtys on 16.02.16.
 */
public class Order extends BaseEntity{
    private User user;
    private List<Pizza> pizzas;
    private Money price;

    public Order() {
        if (pizzas == null) {
            pizzas = new ArrayList<Pizza>();
        }
    }

    public boolean add(Pizza pizza) {
        return pizzas.add(pizza);
    }

    public void remove() {
        if (pizzas != null) {
            pizzas = new ArrayList<Pizza>();
        }
    }


}

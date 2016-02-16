package com.epam.pizza.model;

import org.joda.money.Money;
import java.util.ArrayList;
import java.util.List;

public class Order extends BaseEntity{

    private User user;
    private List<Pizza> pizzas;
    private Address address;
    private Money price = Money.parse("KZT 0.00");

    public Order() {
        if (pizzas == null) {
            pizzas = new ArrayList<>();
        }
    }

    public Order(User user) {
        this.user = user;
        if (pizzas == null) {
            pizzas = new ArrayList<>();
        }
    }

    public boolean add(Pizza pizza) {
        price = price.plus(pizza.getPrice());
        return pizzas.add(pizza);
    }

    public void remove() {
        if (pizzas != null) {
            price = Money.parse("KZT 0.00");
            pizzas = new ArrayList<>();
        }
    }

    public int getCount() {
        return pizzas.size();
    }

    public Money getPrice() {
        return price;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Order" +
                " addressee=" + address.getAddressee() +
                " count=" + getCount() +
                " price=" + getPrice() +
                " address=" + address.getStreet() +
                " h=" + address.getHouseNumber() +
                " f=" + address.getFlatNumber();
    }
}

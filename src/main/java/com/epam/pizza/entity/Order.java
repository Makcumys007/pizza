package com.epam.pizza.entity;

import org.joda.money.Money;

import java.util.HashMap;
import java.util.Map;

public class Order extends BaseEntity {

    private User user;
    private Map<Product, Integer> products;
    private Address address;
    private int size = 0;
    private Money price = Money.parse("KZT 0.00");

    public Order() {
        if (products == null) {
            products = new HashMap<>();
        }
    }

    public void add(Product product) {
        price = price.plus(product.getPrice());
        if (!products.containsKey(product)) {
            products.put(product, 1);
        } else {
            int count = products.get(product);
            count += 1;
            products.put(product, count);
        }
        size++;
    }

    public void remove() {
        if (products != null) {
            price = Money.parse("KZT 0.00");
            products.clear();
        }
    }

    public int getSize() {
        return size;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }
}

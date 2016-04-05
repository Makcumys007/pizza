package com.epam.pizza.entity;

import org.joda.money.Money;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order extends BaseEntity{

    private User user;
    private Map<Product, Integer> products;
    private Address address;
    private Money price = Money.parse("KZT 0.00");

    public Order() {
        if (products == null) {
            products = new HashMap<>();
        }
    }

    public Order(User user) {
        this.user = user;
        if (products == null) {
            products = new HashMap<>();
        }
    }

    public void add(Product product) {
        price = price.plus(product.getPrice());
        if (!products.containsKey(product)){
             products.put(product, 1);
        } else {
            int count = products.get(product);
            count += 1;
            products.put(product, count);
        }
    }

    public void remove() {
        if (products != null) {
            price = Money.parse("KZT 0.00");
            products.clear();
        }
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


}

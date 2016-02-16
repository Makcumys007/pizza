package com.epam.pizza.model;

import org.joda.money.Money;
import java.util.ArrayList;
import java.util.List;

public class Order extends BaseEntity{

    private User user;
    private List<Product> products;
    private Address address;
    private Money price = Money.parse("KZT 0.00");

    public Order() {
        if (products == null) {
            products = new ArrayList<>();
        }
    }

    public Order(User user) {
        this.user = user;
        if (products == null) {
            products = new ArrayList<>();
        }
    }

    public boolean add(Product product) {
        price = price.plus(product.getPrice());
        return products.add(product);
    }

    public void remove() {
        if (products != null) {
            price = Money.parse("KZT 0.00");
            products = new ArrayList<>();
        }
    }

    public int getCount() {
        return products.size();
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

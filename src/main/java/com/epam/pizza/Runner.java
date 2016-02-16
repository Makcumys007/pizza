package com.epam.pizza;

import com.epam.pizza.factory.FactoryAddress;
import com.epam.pizza.factory.FactoryBeer;
import com.epam.pizza.factory.FactoryPizza;
import com.epam.pizza.factory.FactoryUser;
import com.epam.pizza.model.Address;
import com.epam.pizza.model.Order;
import com.epam.pizza.model.Product;
import com.epam.pizza.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Runner {
    private static final Logger log = LoggerFactory.getLogger(Runner.class);
    private static User user = FactoryUser.getUserById(1);
    private static Product pizza = FactoryPizza.getPizzaById(2);
    private static Product beer = FactoryBeer.getBeerById(1);
    private static Order order = new Order(user);
    private static Address address = FactoryAddress.getAddress(0);

    public static void main(String[] args) {
        order.setId(1);
        order.setAddress(address);
        add(pizza);
        add(pizza);
        add(beer);
        remove();
    }

    public static void add(Product value) {
        order.add(value);
        log.info(order.toString());
    }



    public static void remove() {
        order.remove();
        log.info(order.toString());
    }

}

package com.epam.pizza.model;

import com.epam.pizza.factory.FactoryAddress;
import com.epam.pizza.factory.FactoryPizza;
import com.epam.pizza.factory.FactoryUser;
import static junit.framework.Assert.*;
import org.junit.Test;


public class OrderTest {
    private User user = FactoryUser.getUserById(1);
    private Product product = FactoryPizza.getPizzaById(2);
    private Order order = new Order(user);
    private Address address = FactoryAddress.getAddress(0);
    @Test
    public void testOrderAdd() {
        order.setId(1);
        order.setAddress(address);
        order.add(product);
        order.add(product);

        assertEquals("Order addressee=Max count=2 price=KZT 3000.00 address=Republic h=18/2 f=8", order.toString());
    }

    @Test
    public void testOrderRemove() {

        order.setAddress(address);
        order.add(product);
        order.add(product);
        order.remove();


        assertEquals("Order addressee=Max count=0 price=KZT 0.00 address=Republic h=18/2 f=8", order.toString());



    }

}

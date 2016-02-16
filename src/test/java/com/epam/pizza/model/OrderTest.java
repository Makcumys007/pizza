package com.epam.pizza.model;

import com.epam.pizza.factory.FactoryPizza;
import com.epam.pizza.factory.FactoryUser;
import static junit.framework.Assert.*;
import org.junit.Test;

/**
 * Created by advirtys on 16.02.16.
 */
public class OrderTest {
    private User user = FactoryUser.getUserById(1);
    private Pizza pizza = FactoryPizza.getPizzaById(2);
    private Order order = new Order(user);
    @Test
    public void testOrderAdd() {
        order.setId(1);
        order.add(pizza);
        order.add(pizza);

        assertEquals("Order user=1 count=2 price=KZT 3000.00", order.toString());
    }

    @Test
    public void testOrderRemove() {
        order.remove();
        assertEquals("Order user=1 count=0 price=KZT 0.00", order.toString());
    }

}

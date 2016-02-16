package com.epam.pizza.model;

import org.joda.money.Money;
import org.junit.Test;
import static junit.framework.Assert.*;

public class PizzaTest {
    @Test
    public void testPizza() {
        Pizza pizza = new Pizza();
        pizza.setId(1);
        pizza.setTitle("With cheese");
        pizza.setMoney(Money.parse("KZT 1000"));

        assertEquals("Pizza title=With cheese, description=null, money=1000.00", pizza.toString());
    }
}

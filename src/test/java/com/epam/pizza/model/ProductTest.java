package com.epam.pizza.model;

import org.joda.money.Money;
import org.junit.Test;
import static junit.framework.Assert.*;

public class ProductTest {
    @Test
    public void testPizza() {
        Product product = new Product();
        product.setId(1);
        product.setTitle("With cheese");
        product.setPrice(Money.parse("KZT 1000"));

        assertEquals("Product title=With cheese, description=null, price=1000.00", product.toString());
    }
}

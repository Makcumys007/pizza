package com.epam.pizza.factory;

import com.epam.pizza.model.Product;
import org.joda.money.Money;

import java.util.ArrayList;
import java.util.List;

public class FactoryBeer {
    private static List<Product> getBeers() {
        List<Product> products = new ArrayList<Product>();
            Product product = new Product();

            product.setId(1);
            product.setTitle("Жигулевское");
            product.setDescription("не фильтрованное, 0.5 литра");
            product.setPrice(Money.parse("KZT 170.00"));
            products.add(product);

            product = new Product();
            product.setId(2);
            product.setTitle("Карагандинское");
            product.setDescription("темное, 0.5 литра");
            product.setPrice(Money.parse("KZT 160.00"));
            products.add(product);

            product = new Product();
            product.setId(3);
            product.setTitle("Derbes");
            product.setDescription("светлое, 0.5 литра");
            product.setPrice(Money.parse("KZT 180.00"));
            products.add(product);


        return products;
    }

    public static Product getBeerById(int id) {
        Product product = new Product();
        for (int i = 0; i < getBeers().size(); i++) {
            if (id == getBeers().get(i).getId()) {
                product = getBeers().get(i);
            }
        }
        return product;
    }
}

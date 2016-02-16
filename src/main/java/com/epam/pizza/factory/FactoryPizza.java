package com.epam.pizza.factory;

import com.epam.pizza.model.Product;
import org.joda.money.Money;

import java.util.ArrayList;
import java.util.List;

public class FactoryPizza {
    private static List<Product> getPizzas() {
        List<Product> products = new ArrayList<Product>();
            Product product = new Product();
            product.setId(1);
            product.setTitle("Viennese");
            product.setDescription("помидоры, сыр моцарелла," +
                    " немецкие сосиски, орегано, масло");
            product.setPrice(Money.parse("KZT 1500"));
            products.add(product);

            product = new Product();
            product.setId(2);
            product.setTitle("Сapricciosa");
            product.setDescription("сыр моцарелла, томаты, грибы, артишоки," +
                    " (иногда ветчина), зелёные и чёрные оливки, масло");
            product.setPrice(Money.parse("KZT 1500"));
            products.add(product);

            product = new Product();
            product.setId(3);
            product.setTitle("Diabola");
            product.setDescription("острая пицца с большим количеством" +
                    " пепперони и другими ингредиентами");
            product.setPrice(Money.parse("KZT 1500"));
            products.add(product);

            product = new Product();
            product.setId(4);
            product.setTitle("Primavera");
            product.setDescription("томатный соус, моцарелла, оливковое масло, орегано");
            product.setPrice(Money.parse("KZT 1500"));
            products.add(product);

            product = new Product();
            product.setId(5);
            product.setTitle("Hawaii");
            product.setDescription("с ветчиной и ананасом");
            product.setPrice(Money.parse("KZT 1500"));
            products.add(product);

        return products;
    }

    public static Product getPizzaById(int id) {
        Product product = new Product();
        for (int i = 0; i < getPizzas().size(); i++) {
            if (id == getPizzas().get(i).getId()) {
                product = getPizzas().get(i);
            }
        }
        return product;
    }
}

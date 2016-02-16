package com.epam.pizza.factory;

import com.epam.pizza.model.Pizza;
import org.joda.money.Money;

import java.util.ArrayList;
import java.util.List;

public class FactoryPizza {
    private static List<Pizza> getPizzas() {
        List<Pizza> pizzas = new ArrayList<Pizza>();
            Pizza pizza = new Pizza();
            pizza.setId(1);
            pizza.setTitle("Viennese");
            pizza.setDescription("помидоры, сыр моцарелла," +
                    " немецкие сосиски, орегано, масло");
            pizza.setMoney(Money.parse("KZT 1500"));
            pizzas.add(pizza);

            pizza = new Pizza();
            pizza.setId(2);
            pizza.setTitle("Сapricciosa");
            pizza.setDescription("сыр моцарелла, томаты, грибы, артишоки," +
                    " (иногда ветчина), зелёные и чёрные оливки, масло");
            pizza.setMoney(Money.parse("KZT 1500"));
            pizzas.add(pizza);

            pizza = new Pizza();
            pizza.setId(3);
            pizza.setTitle("Diabola");
            pizza.setDescription("острая пицца с большим количеством" +
                    " пепперони и другими ингредиентами");
            pizza.setMoney(Money.parse("KZT 1500"));
            pizzas.add(pizza);

            pizza = new Pizza();
            pizza.setId(4);
            pizza.setTitle("Primavera");
            pizza.setDescription("томатный соус, моцарелла, оливковое масло, орегано");
            pizza.setMoney(Money.parse("KZT 1500"));
            pizzas.add(pizza);

            pizza = new Pizza();
            pizza.setId(5);
            pizza.setTitle("Hawaii");
            pizza.setDescription("с ветчиной и ананасом");
            pizza.setMoney(Money.parse("KZT 1500"));
            pizzas.add(pizza);

        return pizzas;
    }

    public static Pizza getPizzaById(int id) {
        Pizza pizza = new Pizza();
        for (int i = 0; i < getPizzas().size(); i++) {
            if (id == getPizzas().get(i).getId()) {
                pizza = getPizzas().get(i);
            }
        }
        return pizza;
    }
}

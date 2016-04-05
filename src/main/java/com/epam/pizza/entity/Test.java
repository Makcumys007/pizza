package com.epam.pizza.entity;

public class Test {
    public static void main(String[] args) {
        Product.Type pizza = Product.Type.valueOf("PIZZA");
        System.out.println(pizza);
        pizza = Product.Type.valueOf("pizza");
        System.out.println(pizza);
    }
}

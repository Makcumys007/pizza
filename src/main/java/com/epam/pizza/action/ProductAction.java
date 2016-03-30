package com.epam.pizza.action;

import com.epam.pizza.dao.ProductDAO;
import com.epam.pizza.entity.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductAction implements Action {
    private ActionResult product;

    private Product.Type pizzaType = Product.Type.PIZZA;
    private Product.Type sushiType = Product.Type.SUSHI;
    private Product.Type drinkType = Product.Type.DRINK;


    public ProductAction(String page) {
        product = new ActionResult(page);
    }

    @Override
    public ActionResult execute(HttpServletRequest req, HttpServletResponse resp) {
        String type = req.getParameter("type");
        Map<String, List<Product>> mapProduct = getProductList();
        List<Product> listProduct = mapProduct.get(type);

        req.setAttribute("titlePage", getTitlePage(type));
        req.setAttribute("products", listProduct);

        return product;
    }

    private String getTitlePage(String type) {
        Map<String, String> mapTitle = new HashMap<>();

        mapTitle.put(pizzaType.toString().toLowerCase(), "Пицца");
        mapTitle.put(sushiType.toString().toLowerCase(), "Суши");
        mapTitle.put(drinkType.toString().toLowerCase(), "Напитки");

        return mapTitle.get(type);
    }

    private Map<String, List<Product>> getProductList() {
        Map<String, List<Product>> mapProduct = new HashMap<>();

        ProductDAO productDAO = new ProductDAO();
        List<Product> products = productDAO.selectAll();

        List<Product> pizzas = new ArrayList<>();
        List<Product> sushis = new ArrayList<>();
        List<Product> drinks = new ArrayList<>();

        for (Product product : products) {
            if (product.getType() == pizzaType) {
                pizzas.add(product);
            } else if (product.getType() == sushiType) {
                sushis.add(product);
            } else if (product.getType() == drinkType) {
                drinks.add(product);
            }
        }

        mapProduct.put(pizzaType.toString().toLowerCase(), pizzas);
        mapProduct.put(sushiType.toString().toLowerCase(), sushis);
        mapProduct.put(drinkType.toString().toLowerCase(), drinks);

        return mapProduct;
    }
}

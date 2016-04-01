package com.epam.pizza.action;

import com.epam.pizza.dao.ProductDAO;
import com.epam.pizza.entity.Product;
import com.epam.pizza.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class HomeAction implements Action {
    private ActionResult home;

    public HomeAction(String page) {
        home = new ActionResult(page);
    }

    @Override
    public ActionResult execute(HttpServletRequest req, HttpServletResponse resp) {
        ProductDAO productDAO = new ProductDAO();
        List<Product> products = productDAO.selectAll();

        List<Product> pizzas = new ArrayList<>();
        List<Product> sushis = new ArrayList<>();

        for (Product product : products) {
            if (product.getType() == Product.Type.PIZZA) {
                pizzas.add(product);
            } else if (product.getType() == Product.Type.SUSHI) {
                sushis.add(product);
            }
        }

        req.setAttribute("sushis", sushis);
        req.setAttribute("pizzas", pizzas);



        return home;
    }


}

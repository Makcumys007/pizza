package com.epam.pizza.action;

import com.epam.pizza.dao.ProductDAO;
import com.epam.pizza.entity.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        req.setAttribute("products", products);
        return home;
    }
}

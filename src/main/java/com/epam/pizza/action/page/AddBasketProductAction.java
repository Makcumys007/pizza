package com.epam.pizza.action.page;

import com.epam.pizza.action.Action;
import com.epam.pizza.action.ActionResult;
import com.epam.pizza.dao.ProductDAO;
import com.epam.pizza.entity.Order;
import com.epam.pizza.entity.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddBasketProductAction implements Action {
    @Override
    public ActionResult execute(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.selectById(id);
        productDAO.close();


        Order order = (Order) req.getSession(false).getAttribute("order");
        order.add(product);
        req.getSession(false).setAttribute("order", order);

        return new HomeAction("home").execute(req, resp);
    }
}

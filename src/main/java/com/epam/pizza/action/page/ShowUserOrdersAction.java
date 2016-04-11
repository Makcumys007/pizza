package com.epam.pizza.action.page;

import com.epam.pizza.action.Action;
import com.epam.pizza.action.ActionResult;
import com.epam.pizza.dao.OrderDAO;
import com.epam.pizza.entity.Order;
import com.epam.pizza.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowUserOrdersAction implements Action {
    private ActionResult result;
    public ShowUserOrdersAction(String page) {
        result = new ActionResult(page);
    }

    @Override
    public ActionResult execute(HttpServletRequest req, HttpServletResponse resp) {
        User user = (User) req.getSession(false).getAttribute("user");
        OrderDAO orderDAO = new OrderDAO();
        List<Order> orders = orderDAO.selectById(user.getId());
        req.setAttribute("orderList", orders);
        return result;
    }
}

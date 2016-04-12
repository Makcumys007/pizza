package com.epam.pizza.action;

import com.epam.pizza.dao.OrderDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateOrderAction implements Action {
    private ActionResult result;
    public UpdateOrderAction(String page) {
        result = new ActionResult(page, true);
    }

    @Override
    public ActionResult execute(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("orderId"));
        int status = Integer.parseInt(req.getParameter("status"));
        OrderDAO orderDAO = new OrderDAO();
        orderDAO.updateStatus(id, status);
        orderDAO.close();
        return result;
    }
}

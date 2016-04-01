package com.epam.pizza.action;

import com.epam.pizza.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowPageAction implements Action {

    private ActionResult resultPage;

    public ShowPageAction(String page) {
        resultPage = new ActionResult(page);
    }

    @Override
    public ActionResult execute(HttpServletRequest req, HttpServletResponse resp) {
        User user = (User) req.getSession(false).getAttribute("user");
        if (user.getRole().equals("guest")) {
            return resultPage;
        } else {
            return new HomeAction("home").execute(req, resp);
        }
    }
}

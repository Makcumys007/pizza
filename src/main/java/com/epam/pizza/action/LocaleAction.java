package com.epam.pizza.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LocaleAction implements Action {


    @Override
    public ActionResult execute(HttpServletRequest req, HttpServletResponse resp) {
        String locale = req.getParameter("locale");
        req.getSession().setAttribute("locale", locale);
        return new HomeAction("home").execute(req, resp);
    }
}

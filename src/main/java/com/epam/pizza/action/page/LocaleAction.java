package com.epam.pizza.action.page;

import com.epam.pizza.action.Action;
import com.epam.pizza.action.ActionResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LocaleAction implements Action {


    @Override
    public ActionResult execute(HttpServletRequest req, HttpServletResponse resp) {
        String locale = req.getParameter("locale");
        req.getSession().setAttribute("locale", locale);
        return new HomeAction("home").execute(req, resp);
    }
}

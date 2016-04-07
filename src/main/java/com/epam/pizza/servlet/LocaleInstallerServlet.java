package com.epam.pizza.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LocaleInstallerServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String locale = req.getParameter("locale");
        req.getSession().setAttribute("locale", locale);
        String referer = req.getHeader("Referer");

        if (referer.endsWith("login")) {
            referer = referer.replace("login", "");
        }

        System.out.println(locale + " " + referer);

        resp.sendRedirect(referer);
    }
}

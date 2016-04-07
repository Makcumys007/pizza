package com.epam.pizza.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocaleInstallerServlet extends HttpServlet {
    private List<String> refererReplaceList;

    @Override
    public void init() throws ServletException {
        refererReplaceList = new ArrayList<>();
        refererReplaceList.add("login");
        refererReplaceList.add("logout");
        refererReplaceList.add("update-user");
        refererReplaceList.add("edit-product");

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String locale = req.getParameter("locale");
        req.getSession().setAttribute("locale", locale);
        String referer = req.getHeader("Referer");

        for (String replace : refererReplaceList) {
            if (referer.endsWith(replace)) {
                referer = referer.replace(replace, "");
            }
        }
        resp.sendRedirect(referer);
    }
}

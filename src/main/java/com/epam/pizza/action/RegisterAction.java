package com.epam.pizza.action;

import javax.servlet.http.HttpServletRequest;

public class RegisterAction implements Action{
    @Override
    public String execute(HttpServletRequest req) {
        String name = req.getParameter("name");
        System.out.println(name);
        return null;
    }
}

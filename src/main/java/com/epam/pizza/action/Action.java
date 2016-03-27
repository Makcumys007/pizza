package com.epam.pizza.action;

import javax.servlet.http.HttpServletRequest;

public interface Action {
    String execute(HttpServletRequest req);
}

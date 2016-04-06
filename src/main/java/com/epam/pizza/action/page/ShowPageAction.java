package com.epam.pizza.action.page;

import com.epam.pizza.action.Action;
import com.epam.pizza.action.ActionResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowPageAction implements Action {

    private ActionResult resultPage;

    public ShowPageAction(String page) {
        resultPage = new ActionResult(page);
    }

    @Override
    public ActionResult execute(HttpServletRequest req, HttpServletResponse resp) {
        return resultPage;
    }
}

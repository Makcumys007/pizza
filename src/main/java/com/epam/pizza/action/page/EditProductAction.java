package com.epam.pizza.action.page;

import com.epam.pizza.action.Action;
import com.epam.pizza.action.ActionResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditProductAction implements Action {

    private ActionResult result;

    public EditProductAction(String page) {
        result = new ActionResult(page);
    }

    @Override
    public ActionResult execute(HttpServletRequest req, HttpServletResponse resp) {

        return result;
    }
}

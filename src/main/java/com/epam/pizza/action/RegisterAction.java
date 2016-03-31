package com.epam.pizza.action;

import com.epam.pizza.dao.UserDAO;
import com.epam.pizza.entity.User;
import com.epam.pizza.service.UserService;
import com.epam.pizza.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterAction implements Action {
    private ActionResult register;
    public RegisterAction(String page) {
        register = new ActionResult(page, true);
    }

    @Override
    public ActionResult execute(HttpServletRequest req, HttpServletResponse resp) {

        UserService userService = new UserService(req);
        User user;
        try {
            user = userService.getRegisteringUser();
        } catch (ServiceException e) {
            // TODO
            req.setAttribute("validate", true);
            return new ActionResult("register");
        }


        UserDAO userDAO = new UserDAO();
        userDAO.insertEntity(user);

        return register;
    }
}


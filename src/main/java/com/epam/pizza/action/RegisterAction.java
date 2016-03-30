package com.epam.pizza.action;

import com.epam.pizza.dao.UserDAO;
import com.epam.pizza.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterAction implements Action {
    private ActionResult register;
    public RegisterAction(String page) {
        register = new ActionResult(page);
    }

    @Override
    public ActionResult execute(HttpServletRequest req, HttpServletResponse resp) {
        User user = new User();

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);

        UserDAO userDAO = new UserDAO();
        userDAO.insertEntity(user);

        return register;
    }
}


package com.epam.pizza.action;

import com.epam.pizza.dao.UserDAO;
import com.epam.pizza.entity.User;
import com.epam.pizza.service.UserService;
import com.epam.pizza.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction implements Action {

    @Override
    public ActionResult execute(HttpServletRequest req, HttpServletResponse resp) {
        UserDAO userDAO = new UserDAO();
        UserService userService = new UserService(req);
        try {
            User loginUser = userService.getLogingUser();
            User findUser = userDAO.findByEntity(loginUser);

            if (findUser != null && loginUser.getPassword().equals(findUser.getPassword())) {
                req.getSession().setAttribute("user", findUser);
            }

        } catch (ServiceException e) {
            req.setAttribute("validate", true);
            req.setAttribute("login", true);
            return new HomeAction("home").execute(req, resp);
        }
        return new HomeAction("home").execute(req, resp);
    }
}

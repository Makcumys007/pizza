package com.epam.pizza.service;

import com.epam.pizza.entity.User;
import com.epam.pizza.service.exception.ServiceException;
import com.epam.pizza.util.Validation;
import javax.servlet.http.HttpServletRequest;


public class UserService {
    private HttpServletRequest req;
    private Validation validation;

    public UserService(HttpServletRequest req) {
        this.req = req;
        validation = new Validation(req);
    }



    public User getRegisteringUser() throws ServiceException {
        User user = new User();
        if (validation.validate()) {
            user.setLogin(req.getParameter("login"));
            user.setEmail(req.getParameter("email"));
            user.setPassword(req.getParameter("password"));
            return user;
        } else {
            throw new ServiceException("Incorrectly entered data!");
        }
    }




}

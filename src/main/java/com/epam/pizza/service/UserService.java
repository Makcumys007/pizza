package com.epam.pizza.service;

import com.epam.pizza.dao.UserDAO;
import com.epam.pizza.entity.User;
import com.epam.pizza.service.exception.ServiceException;
import com.epam.pizza.util.Validation;
import javax.servlet.http.HttpServletRequest;


public class UserService {
    private HttpServletRequest req;
    private Validation validation;
    private UserDAO userDAO;

    public UserService(HttpServletRequest req) {
        this.req = req;
        userDAO = new UserDAO();
        validation = new Validation(req);
    }



    public User getRegisteringUser() throws ServiceException {
        User user = new User();
        if (validation.validate()) {
            user.setLogin(req.getParameter("login"));
            user.setEmail(req.getParameter("email"));
            user.setPassword(req.getParameter("password"));

            User findUser = userDAO.findByEntity(user);
            if (findUser.getLogin() == null) {
                return user;
            } else {
                req.setAttribute("engaged", true);
                throw new ServiceException("Such a user can not be created!");
            }
        } else {
            throw new ServiceException("Incorrectly entered data!");
        }
    }

    public User getLoginUser() throws ServiceException {
        User user = (User) req.getSession(false).getAttribute("user");
        if (validation.validate()) {
            user.setLogin(req.getParameter("login"));
            user.setPassword(req.getParameter("password"));
            User findUser = userDAO.findByEntity(user);
            if(findUser.getPassword() != null && findUser.getPassword().equals(user.getPassword())){
                return findUser;
            } else {
                throw new ServiceException("Incorrectly entered data!");
            }
        } else {
            throw new ServiceException("Incorrectly entered data!");
        }
    }

    public User getUpdateUser() throws ServiceException {
        User user = (User) req.getSession(false).getAttribute("user");
        if (validation.validate()) {
            user.setEmail(req.getParameter("email"));
            user.setPassword(req.getParameter("password"));
            userDAO.updateEntity(user);

            return user;
        } else {
            throw new ServiceException("Incorrectly entered data!");
        }
    }





}

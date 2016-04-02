package com.epam.pizza.action;

import com.epam.pizza.dao.UserDAO;
import com.epam.pizza.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateUserAction implements Action {
    @Override
    public ActionResult execute(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("update_user_id"));
        String newRole = req.getParameter("new_role");
        UserDAO userDAO = new UserDAO();
        User user = userDAO.selectById(id);
        user.setRole(newRole);
        userDAO = new UserDAO();
        userDAO.updateEntity(user);
        return new UsersControlAction("users-control").execute(req, resp);
    }
}

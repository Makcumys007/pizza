package com.epam.pizza.action.page;

import com.epam.pizza.action.Action;
import com.epam.pizza.action.ActionResult;
import com.epam.pizza.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class RedirectPageAction implements Action {
    private String page;
    private Map<String, Map<String, Action>> actions = new HashMap<>();
    public RedirectPageAction(String page) {
        this.page = page;
        Map<String, Action> register = new HashMap<>();

        register.put("guest", new ShowPageAction(page));
        register.put("admin", new HomeAction("home"));
        register.put("user", new HomeAction("home"));

        Map<String, Action> profile = new HashMap<>();

        profile.put("guest", new HomeAction("home"));
        profile.put("admin", new ShowPageAction(page));
        profile.put("user", new ShowPageAction(page));

        Map<String, Action> control = new HashMap<>();

        control.put("guest", new HomeAction("home"));
        control.put("admin", new ShowPageAction(page));
        control.put("user", new HomeAction("home"));

        Map<String,Action> usersControl = new HashMap<>();

        usersControl.put("guest", new HomeAction("home"));
        usersControl.put("admin", new UsersControlAction(page));
        usersControl.put("user", new HomeAction("home"));

        Map<String, Action> productsControl = new HashMap<>();

        productsControl.put("guest", new HomeAction("home"));
        productsControl.put("admin", new ProductsControlAction(page));
        productsControl.put("user", new HomeAction("home"));

        Map<String, Action> basket = new HashMap<>();

        basket.put("guest", new HomeAction("home"));
        basket.put("admin", new ShowBasketAction(page));
        basket.put("user", new ShowBasketAction(page));

        actions.put("register", register);
        actions.put("profile", profile);
        actions.put("control", control);
        actions.put("users-control",usersControl);
        actions.put("products-control", productsControl);
        actions.put("add-product", control);
        actions.put("basket", basket);

    }

    @Override
    public ActionResult execute(HttpServletRequest req, HttpServletResponse resp) {
        User user = (User) req.getSession(false).getAttribute("user");
        return actions.get(page).get(user.getRole()).execute(req, resp);
    }
}

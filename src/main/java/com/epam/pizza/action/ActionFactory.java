package com.epam.pizza.action;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ActionFactory {
    private Map<String, Action> actions;

    public ActionFactory() {
        actions = new HashMap<>();
        actions.put("GET/", new HomeAction("home"));
        actions.put("GET/contacts", new ShowPageAction("contacts"));
        actions.put("GET/product", new ProductAction("product"));
        actions.put("GET/register", new RedirectPageAction("register"));
        actions.put("POST/register", new RegisterAction());
        actions.put("GET/locale", new LocaleAction());
        actions.put("POST/login", new LoginAction());
        actions.put("GET/logout", new LogoutAction());
        actions.put("GET/profile", new RedirectPageAction("profile"));
        actions.put("POST/profile", new ProfileAction());
        actions.put("GET/control", new RedirectPageAction("control"));
        actions.put("GET/users-control", new RedirectPageAction("users-control"));
        actions.put("POST/update-user", new UpdateUserAction());
        actions.put("POST/delete-user", new DeleteUserAction());
        actions.put("GET/products-control", new RedirectPageAction("products-control"));
        actions.put("GET/add-product", new RedirectPageAction("add-product"));


    }

    public Action getAction(HttpServletRequest req) {
        String key = req.getMethod() + req.getPathInfo();
        System.out.println(key);
        return actions.get(key);
    }

}

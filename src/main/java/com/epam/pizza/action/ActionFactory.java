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
        actions.put("GET/register", new ShowPageAction("register"));
        actions.put("POST/register", new RegisterAction());
        actions.put("GET/locale", new LocaleAction());
        actions.put("POST/login", new LoginAction());

    }

    public Action getAction(HttpServletRequest req) {
        String key = req.getMethod() + req.getPathInfo();
        System.out.println(key);
        return actions.get(key);
    }
}

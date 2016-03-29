package com.epam.pizza.action;


import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ActionFactory {
    private Map<String, Action> actions;

    public ActionFactory() {
        actions = new HashMap<>();
        actions.put("GET/", new ShowPageAction("home"));

    }

    public Action getAction(HttpServletRequest req) {
        String key = req.getMethod() + req.getPathInfo();
        System.out.println(key);
        return actions.get(key);
    }
}

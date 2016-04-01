package com.epam.pizza.action;

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

        actions.put("register", register);
        actions.put("profile", profile);

    }

    @Override
    public ActionResult execute(HttpServletRequest req, HttpServletResponse resp) {
        User user = (User) req.getSession(false).getAttribute("user");
        System.out.println(user.getRole());
        return actions.get(page).get(user.getRole()).execute(req, resp);
    }
}

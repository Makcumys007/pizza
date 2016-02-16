package com.epam.pizza.factory;

import com.epam.pizza.model.Role;
import com.epam.pizza.model.User;
import java.util.ArrayList;
import java.util.List;


public class FactoryUser {
    private static List<User> getUsers() {
        List<User> users = new ArrayList<User>();
            User user = new User(Role.Guest);
            users.add(user);

            user = new User(Role.User);
            user.setId(1);
            user.setLogin("1");
            user.setPassword("1");
            user.setEmail("1@gmail.com");
            users.add(user);

            user = new User(Role.User);
            user.setId(2);
            user.setLogin("2");
            user.setPassword("2");
            user.setEmail("2@gmail.com");
            users.add(user);

            user = new User(Role.Admin);
            user.setId(3);
            user.setLogin("3");
            user.setPassword("3");
            user.setEmail("3@gmail.com");
            users.add(user);

        return users;
    }

    public static User getUserById(int id) {
        User user = new User();
        for (int i = 0; i < getUsers().size(); i++) {
            if (id == getUsers().get(i).getId()) {
                user = getUsers().get(i);
            }
        }
        return user;
    }
}

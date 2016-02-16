package com.epam.pizza.factory;

import com.epam.pizza.model.Address;
import com.epam.pizza.model.Group;
import com.epam.pizza.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by advirtys on 16.02.16.
 */
public class FactoryUser {
    private List<User> getUsers() {
        List<User> users = new ArrayList<User>();
            User user = new User(Group.Guest);
            users.add(user);

            Address ad1 = new Address();
            ad1.setAddressee("Abylkassov Maxim");
            ad1.setHouseNumber("18/2");
            ad1.setFlatNumber(18);
            ad1.setStreet("Republic");
            user = new User(Group.User);
            user.setId(1);
            user.setLogin("1");
            user.setPassword("1");
            user.setEmail("1@gmail.com");
            user.setAddress(ad1);
            users.add(user);

            ad1 = new Address();
            ad1.setAddressee("Abylkassov Kristina");
            ad1.setHouseNumber("22");
            ad1.setFlatNumber(53);
            ad1.setStreet("Sabitova");
            user = new User(Group.User);
            user.setId(2);
            user.setLogin("2");
            user.setPassword("2");
            user.setEmail("2@gmail.com");
            user.setAddress(ad1);
            users.add(user);

            user = new User(Group.Admin);
            user.setId(3);
            user.setLogin("3");
            user.setPassword("3");
            user.setEmail("3@gmail.com");
            users.add(user);

        return users;
    }

    public User getUserById(int id) {
        User user = new User();
        for (int i = 0; i < getUsers().size(); i++) {
            if (id == getUsers().get(i).getId()) {
                user = getUsers().get(i);
            }
        }
        return user;
    }
}

package com.example.springusermodel.dao;


import com.example.springusermodel.model.Login;
import com.example.springusermodel.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static List<User> users;
    static {
        users = new ArrayList<>();
        users.add(new User("john1","123456","john","john@codegym.vn",10));
        users.add(new User("john2","123456","john","john@codegym.vn",10));
        users.add(new User("john3","123456","john","john@codegym.vn",10));

    }

    public static User checkLogin(Login login){
        for (User u: users) {
            if(u.getAccount().equals(login.getAccount())
                    && u.getPassword().equals(login.getPassword())){
                return u;
            }
        }
        return null;
    }
}
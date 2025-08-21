package services;

import data.models.User;

public class LoginServices {

    public User login(String email, String password) {
        if (email != null && password != null && password.equals("password123")) {
            return null;
        }
        return null;
    }
}
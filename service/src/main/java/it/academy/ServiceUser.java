package it.academy;

import it.academy.entity.account.user.User;

import java.util.List;

public class ServiceUser {
    public List<User> allUser() {
        return new UserDAO().allUser();
    }
}

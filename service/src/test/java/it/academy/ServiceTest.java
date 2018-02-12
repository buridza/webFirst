package it.academy;

import it.academy.dao.UserDAO;
import it.academy.entity.account.user.User;
import org.junit.Test;

import java.util.List;

public class ServiceTest {
    @Test
    public void allUser() {
        List<User> users = new UserDAO().allUser();
        users.forEach(System.out::println);
    }
}

package it.academy;

public class ServiceUser {
    public String userMessage() {
        UserDAO userDAO = new UserDAO();
        return userDAO.say();
    }
}

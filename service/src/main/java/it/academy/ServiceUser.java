package it.academy;

public class ServiceUser {
    public String userMessage() {
        return new UserDAO().say();
    }
}

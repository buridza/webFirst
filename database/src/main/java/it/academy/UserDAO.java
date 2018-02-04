package it.academy;

import it.academy.entity.account.user.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UserDAO {

    public List<User> allUser() {
        final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<User> resultList = session.createQuery("select a from User a", User.class).getResultList();

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return resultList;
    }


}

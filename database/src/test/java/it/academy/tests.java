package it.academy;

import it.academy.entity.Purchase;
import it.academy.entity.account.Address;
import it.academy.entity.account.admin.Admin;
import it.academy.entity.account.admin.Role;
import it.academy.entity.account.provider.Provider;
import it.academy.entity.account.provider.Requisites;
import it.academy.entity.account.user.Language;
import it.academy.entity.account.user.User;
import it.academy.entity.game.Game;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class tests {
    private static final SessionFactory SESSION_FACTORY =
            new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

    @Test
    public void testUser() {
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();
        User user = new User(
                new Address(
                        "Belarus",
                        "Minsk",
                        10,
                        10),
                "Alex",
                "TheBest",
                "12345",
                "THeBest@gmail.com",
                LocalDate.now(),
                Language.RUSSIAN);
        session.save(user);

        session.getTransaction().commit();
        session.close();
    }
    @Test
    public void testGame(){
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();
        Game game = new Game();
        game.setAgeRestrictions(10);
        game.setCost(100);
        game.setLanguage(Language.ENGLISH);
        game.setName("Durak");
        Requisites requisites = new Requisites("User",
                1234L,
                34563L,
                "56545");
        Provider provider = new Provider(new Address("Minsk", "Lopatina",
                20, 30),"NIrVaNA", "BestCompany",
                "12345", "nirvana@gmail.com",
                requisites);
        game.setProvider(
                provider);
        game.setNumberOfPlayers(10);
        game.setRules("Убивать нельзя");
        session.save(provider);
        session.save(game);
        session.getTransaction().commit();
        session.close();
    }
    @Test
    public void testOrder(){
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();

        Purchase purchase = new Purchase();
        purchase.setDate(LocalDate.now());

        Provider provider = new Provider(
                new Address(
                        "Vitebsk",
                        "volnaya",
                        10,
                        45),
                "Ivan",
                "proGame",
                "12345",
                "petya@gmail.com",
                new Requisites(
                        "bank",
                        1456L,
                        54245L,
                        "paym")
        );
        Game game = new Game("Pasians", "kill all", 50, 30, 4, Language.RUSSIAN,
                provider);
        purchase.setGame(game);

        purchase.setPaymentStatus(true);

        User user = new User(new Address("Minsk", "kijevatova", 10, 34),
                "Leha", "polk", "12345", "polkan@gmail.com", LocalDate.now(),
                Language.RUSSIAN);
        purchase.setUser(user);
        session.save(provider);
        session.save(game);
        session.save(user);
        session.save(purchase);

        session.getTransaction().commit();
        session.close();
    }
    @Test
    public void testAdmin(){
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();
        Admin admin = new Admin();
        admin.setRole(Role.MODERATOR);
        admin.setAddress(new Address("Minsk", "sq.Lenina", 53, 1));
        admin.setEmail("admin@gmail.com");
        admin.setLogin("god");
        admin.setName("Ignat");
        admin.setPassword("12345");

        session.save(admin);
        session.getTransaction().commit();
        session.close();
    }
    @Test
    public void testProvider(){
        Session session = SESSION_FACTORY.openSession();
        session.beginTransaction();
        Provider provider = new Provider(
                new Address(
                        "Vitebsk",
                        "volnaya",
                        10,
                        91),
                "Ivan",
                "EA",
                "12345",
                "EA@gmail.com",
                new Requisites(
                        "smth",
                        14526L,
                        544245L,
                        "smth")

        );
        session.getTransaction().commit();
        session.close();
    }


       @AfterClass
    public static void fin() {
        SESSION_FACTORY.close();
    }
}

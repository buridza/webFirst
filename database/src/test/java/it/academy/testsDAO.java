package it.academy;

import it.academy.dao.inher.account.*;
import it.academy.dao.inher.game.GameDAO;
import it.academy.entity.account.Address;
import it.academy.entity.account.admin.Admin;
import it.academy.entity.account.admin.Role;
import it.academy.entity.account.provider.Provider;
import it.academy.entity.account.provider.Requisites;
import it.academy.entity.account.user.Comment;
import it.academy.entity.account.user.Friends;
import it.academy.entity.account.user.Language;
import it.academy.entity.account.user.User;
import it.academy.entity.game.Game;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class testsDAO {
    public static final SessionFactory SESSION_FACTORY = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    public void before(){

    }
    @Test
    public void accountAdminTest(){
        Session session = SESSION_FACTORY.openSession();
        Admin admin = new Admin();

        admin.setRole(Role.MODERATOR);
        admin.setAddress(new Address("Minsk", "sq.Lenina", 53, 1));
        admin.setEmail("admin@gmail.com");
        admin.setLogin("god");
        admin.setName("Ignat");
        admin.setPassword("12345");

        AdminDAO adminDAO = new AdminDAO();
        adminDAO.save(session, admin);

        assertThat(session.get(Admin.class, 1L), is(admin));
       // System.out.println("sout 1 " + session.get(Admin.class, 1L));

        admin.setRole(Role.GAME_MASTER);
        adminDAO.update(session,admin);

        assertThat(session.get(Admin.class, 1L), is(admin));

        adminDAO.delete(session,admin);

        Admin admin1 = session.get(Admin.class, 1L);
        assertThat(admin1, is(nullValue()));

        adminDAO.save(session, admin);
        admin1 = session.get(Admin.class, 2L);

        assertThat(adminDAO.findByID(session,5L), is(nullValue()));

        admin1.setLogin("aristrch");

        admin1.setAddress(new Address("Minsk", "sq.Lenina", 32, 3));

        admin1.setEmail("topintheworld@gmail.com");
        adminDAO.save(session,admin1);
        System.out.println(adminDAO.findAll(session));
        assertThat(adminDAO.findAll(session).isEmpty(), is(false));

        session.close();

    }

    @Test
    public void accountCommentTest(){
        Session session = SESSION_FACTORY.openSession();


        CommentDAO commentDAO = new CommentDAO();
        Comment comment = new Comment();

        Game game = new Game();
        comment.setGame(game);
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
        game.setProvider(provider);
        new ProviderDAO().save(session, provider);
        game.setNumberOfPlayers(10);
        game.setRules("Убивать нельзя");
        comment.setMessage("Хорошая игра");
        comment.setRating(5);
        User user = new User(new Address("Minsk", "kijevatova", 10, 34),
                "Leha", "polk", "12345", "polkan@gmail.com", LocalDate.now(),
                Language.RUSSIAN);


        comment.setUser(user);
        new GameDAO().save(session,game);
        new UserDAO().save(session,user);
        new CommentDAO().save(session, comment);

        session.close();
    }
    @Test
    public void accountFriendsDAO(){
        Session session = SESSION_FACTORY.openSession();

        FriendsDAO friendsDAO = new FriendsDAO();


        Friends friends = new Friends();
        User user = new User(
                new Address(
                        "Belarus",
                        "Minsk",
                        10,
                        15),
                "Alex",
                "TheBest1",
                "12345",
                "THeBest1@gmail.com",
                LocalDate.now(),
                Language.RUSSIAN);
        new UserDAO().save(session, user);
        friends.getFriend().add(user);
        friendsDAO.save(session, friends);

        session.close();
    }
    @Test
    public void accountProviderDAO(){
        Session session = SESSION_FACTORY.openSession();

        ProviderDAO providerDAO = new ProviderDAO();
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
        providerDAO.save(session, provider);
        session.close();
    }
    @Test
    public void accountUserDAO(){
        Session session = SESSION_FACTORY.openSession();
        UserDAO userDAO = new UserDAO();

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

        userDAO.save(session, user);

        session.close();
    }
    /*@Test
    public void createNewRecord(){
        for (int i = 0; i < 100; i++) {
            gameDAO();
        }
    }*/
    @Test
    public void gameDAO(){
        Session session = SESSION_FACTORY.openSession();
        Random random = new Random();
        Provider provider = new Provider(
                new Address(
                        "Vitebsk" + random.nextInt(1526),
                        "volnaya"+ random.nextInt(1526),
                        + random.nextInt(1526),
                        + random.nextInt(1526)),
                "Ivan"+ random.nextInt(1526),
                "proGame"+ random.nextInt(1526),
                "12345"+ random.nextInt(1526),
                "petya@gmail.com"+ random.nextInt(1526),
                new Requisites(
                        "bank"+ random.nextInt(1526),
                        1456L+ random.nextInt(1526),
                        54245L+ random.nextInt(1526),
                        "paym"+ random.nextInt(1526))
        );
        Game game = new Game("Pasians"+ random.nextInt(1526), "kill all"+ random.nextInt(1526),
                random.nextInt(1526), random.nextInt(1526),
                random.nextInt(1526),
                Language.values()[random.nextInt(3)],
                provider);
        new ProviderDAO().save(session, provider);
        new GameDAO().save(session,game);
        session.close();
    }

}

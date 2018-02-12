package it.academy.dao.inher.game;

import com.querydsl.jpa.impl.JPAQuery;
import it.academy.dao.BaseDao;
import it.academy.entity.game.Game;
import it.academy.entity.game.QGame;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class GameDAO extends BaseDao<Game> {

    public List<Game> getGameOffsetLimit(long off, long lim){
        SessionFactory SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
        Session session = SESSION_FACTORY.openSession();

        session.beginTransaction();
        JPAQuery<Game> query = new JPAQuery<>(session);
        QGame game = QGame.game;
        query.select(game)
                .from(game)
                .offset(off)
                .limit(lim);
        session.getTransaction().commit();
        return query.fetchResults().getResults();
    }
}

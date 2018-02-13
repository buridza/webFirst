package it.academy.dao.inher.game;

import com.querydsl.jpa.impl.JPAQuery;
import it.academy.dao.BaseDao;
import it.academy.entity.account.user.Language;
import it.academy.entity.game.Game;
import it.academy.entity.game.QGame;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class GameDAO extends BaseDao<Game> {
    SessionFactory SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    Session session = SESSION_FACTORY.openSession();

    private JPAQuery<Game> query = new JPAQuery<>(session);
    private QGame game = QGame.game;

    public List<Game> getGames() {


        query.select(game)
                .from(game);

        return query.fetchResults().getResults();
    }

    public void getGameOffsetLimit(long off, long lim){


        //session.beginTransaction();
        //JPAQuery<Game> query = new JPAQuery<>(session);
        //QGame game = QGame.game;
        query.offset(off)
                .limit(lim);
       // session.getTransaction().commit();
        //return query.fetchResults().getResults();
    }

    public void filter(String name, int cost, int ageRest, Language language) {
       // query = new JPAQuery<>(session);


            query.where(game.cost.goe(cost))
                .where(game.ageRestrictions.goe(ageRest));
        if(!name.isEmpty()){
            query.where(game.name.eq(name));
        }
        if(language != null){
            query.where(game.language.eq(language));
        }
       // session.getTransaction().commit();

       // return query.fetchResults().getResults();
    }


}

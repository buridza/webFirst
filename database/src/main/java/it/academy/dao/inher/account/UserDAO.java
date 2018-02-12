package it.academy.dao.inher.account;

import com.querydsl.jpa.impl.JPAQuery;
import it.academy.dao.BaseDao;
import it.academy.entity.account.user.Friends;
import it.academy.entity.account.user.QFriends;
import it.academy.entity.account.user.QUser;
import it.academy.entity.account.user.User;
import org.hibernate.Session;

public class UserDAO extends BaseDao<User> {

    public Friends getAllFriendsByUser(Session session, User user) {

        session.beginTransaction();

        JPAQuery<Friends> query = new JPAQuery<>(session);
        QUser qUser = QUser.user;
        QFriends friends = QFriends.friends;

        query.select(friends)
                .from(qUser)
                .where(friends.id.eq(qUser.id));

        session.getTransaction().commit();


        return query.fetchOne();
    }
}

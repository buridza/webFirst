package it.academy.dao.inher.account;

import com.querydsl.jpa.impl.JPAQuery;
import it.academy.dao.BaseDao;
import it.academy.entity.account.provider.Provider;
import it.academy.entity.account.provider.QProvider;
import it.academy.entity.account.provider.Requisites;
import org.hibernate.Session;

public class ProviderDAO extends BaseDao<Provider> {

    public Requisites getRequisitesFromProviderByName(Session session, String name) {

        session.beginTransaction();
        JPAQuery<Requisites> query = new JPAQuery<>(session);
        QProvider provider = QProvider.provider;
        query.select(provider)
                .from(provider)
                .where(provider.name.eq(name));
        session.getTransaction().commit();


        return query.fetchFirst();

    }


}

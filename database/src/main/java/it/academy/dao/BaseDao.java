package it.academy.dao;

import it.academy.entity.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public class BaseDao<T extends BaseEntity> {
    //save, update, delete, findByID, findALL
    protected static final SessionFactory SESSION_FACTORY = new Configuration().configure().buildSessionFactory();

    private  Class<T> entityClass;

    public BaseDao() {
        ParameterizedType parameterizedSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        entityClass = (Class<T>) parameterizedSuperclass.getActualTypeArguments()[0];
    }

    public void save(Session session, T obj) {
        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();

    }
    public void update(Session session, T obj) {

        session.beginTransaction();

        session.update(obj);

        session.getTransaction().commit();

    }
    public void delete(Session session, T obj) {

        session.beginTransaction();
        session.delete(obj);
        /*session.createQuery("delete from " + entityClass.getSimpleName() + " t where t.id = :id")
                .setParameter("id", obj.getId())
                .executeUpdate();*/

        session.getTransaction().commit();

    }
    public T findByID(Session session, long id) {

        session.beginTransaction();

        T result = session.get(entityClass, id);

        session.getTransaction().commit();


        return result;
    }

    public List<T> findAll(Session session) {

        session.beginTransaction();

        String simpleName = entityClass.getSimpleName();

        List<T> resultList = session.createQuery("select t from " + simpleName + " t", entityClass).getResultList();

        session.getTransaction().commit();

        return resultList;
    }
}

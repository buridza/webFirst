package it.academy.dao.inher.account;

import it.academy.dao.BaseDao;
import it.academy.entity.account.admin.Admin;
import it.academy.entity.account.admin.Role;
import org.hibernate.Session;

import java.util.List;

public class AdminDAO extends BaseDao<Admin> {
    public List<Admin> findByRole(Session session, Role role) {

        session.beginTransaction();

        List<Admin> list = session.createQuery("select adm from Admin adm where adm.role = :role", Admin.class)
                .setParameter("role", role)
                .getResultList();

        session.getTransaction().commit();


        return list;
    }
}

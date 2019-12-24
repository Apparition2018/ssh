package com.imooc.employee.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @author Arsenal
 * created on 2019/2/25 1:27
 */
public class HibernateUtil {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }
}

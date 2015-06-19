/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.etracker.database;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Ali
 */
public class Database {
    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
//    public static List getQueryResultSet(String namedQuery, String paramName, String paramValue) throws HibernateException {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        Query query = session.getNamedQuery(namedQuery);
//        query.setString(paramName, paramValue);
//        session.getTransaction().commit();
//        session.close();
//        return query.list();
//    }
}

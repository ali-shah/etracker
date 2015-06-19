/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.etracker.service;

import com.github.etracker.model.Vehicle;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ali
 */
public class Helper {
    public static List getQueryResultSet(SessionFactory sessionFactory, String namedQuery, String paramName, String paramValue) throws HibernateException {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.getNamedQuery(namedQuery);
        if(!(paramName == null || paramName.isEmpty())) {
            query.setString(paramName, paramValue);
        }
        List result = query.list();
        session.getTransaction().commit();
        session.close();
        return result;
    }
}

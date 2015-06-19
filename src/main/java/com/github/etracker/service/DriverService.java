/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.etracker.service;

import com.github.etracker.database.Database;
import com.github.etracker.model.Driver;
import com.github.etracker.model.DriverResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ali
 */
public class DriverService {
    private SessionFactory sessionFactory = Database.getSessionFactory();
    
    public DriverService() {
        
    }
    
    public Driver getDriver(String driverName) {
        List<Driver> drivers = Helper.getQueryResultSet(sessionFactory, "Driver.findByName", "name", driverName);
        Iterator<Driver> iter = drivers.iterator();
        Driver driver = new Driver();
        while (iter.hasNext()) {
            driver = iter.next();
        }
        return driver;
    }

    public List<Driver> getDrivers() {
        return Helper.getQueryResultSet(sessionFactory, "Driver.findAll", "", "");
    }
}

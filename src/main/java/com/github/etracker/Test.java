/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.etracker;

import com.github.etracker.model.Driver;
import com.github.etracker.model.Location;
import com.github.etracker.model.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Ali
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("HELLOW WORLD");
        //create first vehicle
        Driver driver1 = new Driver("Alex", "Gibson", 30);
        Vehicle vehicle1 = new Vehicle("DUC356", "Freightliner Unimog");
        Location loc1 = new Location(-36.846160, 174.775951, "Auckland");
        loc1.setTimezone();
        vehicle1.setLocation(loc1);
        vehicle1.setDriver(driver1);
        driver1.setVehicle(vehicle1);
        //create second vehicle
        Driver driver2 = new Driver("James", "Green", 25);
        Vehicle vehicle2 = new Vehicle("ATC100", "Ford F-750");
        Location loc2 = new Location(-36.847121, 174.765909, "Auckland");
        loc2.setTimezone();
        vehicle2.setLocation(loc2);
        vehicle2.setDriver(driver2);
        driver2.setVehicle(vehicle2);
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //save data here
        session.save(driver1);
        session.save(driver2);
        session.save(vehicle1);
        session.save(vehicle2);
        session.getTransaction().commit();
        session.close();
        
        //load an object
        
        session = sessionFactory.openSession();
        session.beginTransaction();
        Driver d = (Driver) session.get(Driver.class, 1);
        session.getTransaction().commit();
        session.close();
        System.out.println(d.getVehicle().getMakeModel());
        System.out.println(d.getVehicle().getLocation().getCity());
        System.out.println(d.getVehicle().getLocation().getTimezone());
        System.exit(0);
    }
    
}

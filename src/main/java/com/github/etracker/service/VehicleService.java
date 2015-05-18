/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.etracker.service;

import com.github.etracker.database.Database;
import com.github.etracker.TrackingInfo;
import com.github.etracker.model.Vehicle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ali
 */
public class VehicleService {
    private SessionFactory sessionFactory = Database.getSessionFactory();
    
    
    public VehicleService() {
    }
       
    public List<TrackingInfo> getAllVehicles() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.getNamedQuery("Vehicle.findAll");
        List<Vehicle> vehicles = (List<Vehicle>) query.list();
        List<TrackingInfo> trackingDetails = new ArrayList<>();
        session.getTransaction().commit();
        session.close();
        for(Vehicle vehicle : vehicles) {
            TrackingInfo ti = new TrackingInfo();
            ti.setCity(vehicle.getLocation().getCity());
            ti.setDriverName(vehicle.getDriver().getFirstName());
            ti.setLangitude(vehicle.getLocation().getLangitude());
            ti.setLatitude(vehicle.getLocation().getLatitude());
            ti.setTimezone(vehicle.getLocation().getTimezone());
            ti.setVehicleRego(vehicle.getRego());
            trackingDetails.add(ti);
        }
        return trackingDetails;
    }
    
    public TrackingInfo getVehicle(String rego) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.getNamedQuery("Vehicle.findByRego");
        query.setString("rego", rego);
        List<Vehicle> vehicles = (List<Vehicle>) query.list();
        List<TrackingInfo> trackingDetails = new ArrayList<>();
        session.getTransaction().commit();
        session.close();
        for(Vehicle vehicle : vehicles) {
            TrackingInfo ti = new TrackingInfo();
            ti.setCity(vehicle.getLocation().getCity());
            ti.setDriverName(vehicle.getDriver().getFirstName());
            ti.setLangitude(vehicle.getLocation().getLangitude());
            ti.setLatitude(vehicle.getLocation().getLatitude());
            ti.setTimezone(vehicle.getLocation().getTimezone());
            ti.setVehicleRego(vehicle.getRego());
            trackingDetails.add(ti);
        }
        TrackingInfo info = new TrackingInfo();
        Iterator<TrackingInfo> iter = trackingDetails.iterator();
        while(iter.hasNext()) {
            info = iter.next();
        }
        return info;
    }
    
}

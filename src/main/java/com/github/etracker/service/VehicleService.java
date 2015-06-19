package com.github.etracker.service;

import com.github.etracker.database.Database;
import com.github.etracker.model.VehicleResponse;
import com.github.etracker.model.Vehicle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ali
 */
public class VehicleService {
    private SessionFactory sessionFactory = Database.getSessionFactory();
    
    public VehicleService() {
    }
       
    public List<VehicleResponse> getAllVehicles() {
        List<Vehicle> vehicles = Helper.getQueryResultSet(sessionFactory,"Vehicle.findAll","","");
        List<VehicleResponse> trackingDetails = new ArrayList<>();
        for(Vehicle vehicle : vehicles) {
            VehicleResponse res = new VehicleResponse();
            updateTrackingInfo(res, vehicle);
            trackingDetails.add(res);
        }
        return trackingDetails;
    }
    
    public VehicleResponse getVehicle(String rego) {
        List<Vehicle> vehicles = Helper.getQueryResultSet(sessionFactory, "Vehicle.findByRego","rego",rego);
        List<VehicleResponse> trackingDetails = new ArrayList<>();
        for(Vehicle vehicle : vehicles) {
            VehicleResponse res = new VehicleResponse();
            updateTrackingInfo(res, vehicle);
            trackingDetails.add(res);
        }
        VehicleResponse info = new VehicleResponse();
        Iterator<VehicleResponse> iter = trackingDetails.iterator();
        while(iter.hasNext()) {
            info = iter.next();
        }
        return info.getTimezone()==null? null: info;
    }
    
    private void updateTrackingInfo(VehicleResponse ti, Vehicle vehicle) {
            ti.setCity(vehicle.getLocation().getCity());
            ti.setDriverName(vehicle.getDriver().getFirstName());
            ti.setLangitude(vehicle.getLocation().getLangitude());
            ti.setLatitude(vehicle.getLocation().getLatitude());
            ti.setTimezone(vehicle.getLocation().getTimezone());
            ti.setVehicleRego(vehicle.getRego());
    }
    
}

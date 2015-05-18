/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.etracker.resources;

import com.github.etracker.TrackingInfo;
import com.github.etracker.service.VehicleService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Ali
 */

//@Consumes(MediaType.APPLICATION_JSON)
@Path("/vehicles")
public class VehicleResource {
    private VehicleService service = new VehicleService();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TrackingInfo> getAllVehicles() {
        return service.getAllVehicles();
    }
    
    @GET
    @Path("/{vehicleRego}")
    @Produces(MediaType.APPLICATION_JSON)
    public TrackingInfo getVehicle(@PathParam("vehicleRego") String rego) {
        return service.getVehicle(rego);
//        TrackingInfo ti = new TrackingInfo();
//            ti.setCity("auckland");
//            ti.setDriverName("James");
//            ti.setLangitude(-44.000);
//            ti.setLatitude(-35.0000);
//            ti.setTimezone("Auckland/Pacific");
//            ti.setVehicleRego("DUC356");
//        return ti;
    }

}

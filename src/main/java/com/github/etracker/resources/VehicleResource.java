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
import javax.ws.rs.core.Response;

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
        List<TrackingInfo> allVehicles = service.getAllVehicles();
        return allVehicles;
//         return Response.ok(allVehicles).build(); //200
//			.header("Access-Control-Allow-Origin", "*")
//			.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
//			.allow("OPTIONS").build();
    }
    
    @GET
    @Path("/{vehicleRego}")
    @Produces(MediaType.APPLICATION_JSON)
    public TrackingInfo getVehicle(@PathParam("vehicleRego") String rego) {
        TrackingInfo ti =  service.getVehicle(rego);
        return ti;
//        return Response.ok() //200
//			.entity(ti)
//			.header("Access-Control-Allow-Origin", "*")
//			.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
//			.allow("OPTIONS").build();
    }

}

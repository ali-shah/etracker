package com.github.etracker.resources;

import com.github.etracker.model.Driver;
import com.github.etracker.model.DriverResponse;
import com.github.etracker.service.DriverService;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Ali
 */
@Path("/drivers")
public class DriverResource {
    private DriverService service = new DriverService();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DriverResponse> getDrivers() {
        List<Driver> drivers =  service.getDrivers();
        List<DriverResponse> responses = new ArrayList<>();
        for(Driver driver : drivers) {
            responses.add(prepareResponse(driver));
        }
        return responses;
    }
    
    @GET
    @Path("/{driverName}")
    @Produces(MediaType.APPLICATION_JSON) 
    public DriverResponse getDriver(@PathParam("driverName") String driverName, @Context UriInfo uriInfo) {
        Driver driver = service.getDriver(driverName);
        DriverResponse response = prepareResponse(driver);
        response.addLink(getUriForSelf(uriInfo, response), "self");
        response.addLink(getUriForVehicle(uriInfo, response), "vehicle");
        return response;
    }

    private DriverResponse prepareResponse(Driver driver) {
        DriverResponse response = new DriverResponse();
        response.setId(driver.getId());
        response.setAge(driver.getAge());
        response.setFirstName(driver.getFirstName());
        response.setLastName(driver.getLastName());
        response.setRego(driver.getVehicle().getRego());
        return response;
    }
    
    private String getUriForSelf(UriInfo uriInfo, DriverResponse response) {
        return uriInfo.getBaseUriBuilder()
                .path(DriverResource.class)
                .path(response.getFirstName())
                .build()
                .toString();
    }
    
    private String getUriForVehicle(UriInfo uriInfo, DriverResponse response) {
        return uriInfo.getBaseUriBuilder()
                .path(VehicleResource.class)
                .path(response.getRego())
                .build()
                .toString();
    }
}

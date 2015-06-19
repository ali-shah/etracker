package com.github.etracker.resources;

import com.github.etracker.model.VehicleResponse;
import com.github.etracker.service.VehicleService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilderException;
import javax.ws.rs.core.UriInfo;

/**
 * @author Ali
 */

@Path("/vehicles")
public class VehicleResource {
    private VehicleService service = new VehicleService();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<VehicleResponse> getAllVehicles() {
        return service.getAllVehicles();
    }
    
    @GET
    @Path("/{vehicleRego}")
    @Produces(MediaType.APPLICATION_JSON)
    public VehicleResponse getVehicle(@PathParam("vehicleRego") String rego, @Context UriInfo uriInfo) {
        VehicleResponse response = service.getVehicle(rego);
        if(response!= null) {
            response.addLink(getUriForSelf(uriInfo, response), "self");
            response.addLink(getUriForDriver(uriInfo, response), "driver");
        }
        return response;
    }

    private String getUriForSelf(UriInfo uriInfo, VehicleResponse res) throws IllegalArgumentException, UriBuilderException {
        return uriInfo.getBaseUriBuilder()
                .path(VehicleResource.class)
                .path(res.getVehicleRego())
                .build()
                .toString();
    }

    private String getUriForDriver(UriInfo uriInfo, VehicleResponse res) {
        String uri = uriInfo.getBaseUriBuilder()
                .path(DriverResource.class)
                .path(res.getDriverName())
                .build()
                .toString();
        return uri;
    }

}

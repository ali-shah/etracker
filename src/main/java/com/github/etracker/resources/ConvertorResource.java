/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.etracker.resources;

import com.github.etracker.LocationAndTime;
import com.github.etracker.service.ConvertorService;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Ali
 */
@Path("/convertor")
public class ConvertorResource {
    private ConvertorService convertorService = new ConvertorService();
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public LocationAndTime convert(LocationAndTime data) {
        convertorService.update(data);
        return data;
    }
}

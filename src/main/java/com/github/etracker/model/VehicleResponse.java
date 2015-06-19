package com.github.etracker.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ali
 */
public class VehicleResponse {
    
    private String driverName;
    private String timezone;
    private String vehicleRego;
    private String city;
    private double latitude;
    private double langitude;
    private List<Link> links;

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public void addLink(String url, String rel) {
       if(links == null) {
           links = new ArrayList<>();
       }
       Link link = new Link();
       link.setLink(url);
       link.setRel(rel);
       links.add(link); 
    }
    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getVehicleRego() {
        return vehicleRego;
    }

    public void setVehicleRego(String vehicleRego) {
        this.vehicleRego = vehicleRego;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLangitude() {
        return langitude;
    }

    public void setLangitude(double langitude) {
        this.langitude = langitude;
    }
    
    
}

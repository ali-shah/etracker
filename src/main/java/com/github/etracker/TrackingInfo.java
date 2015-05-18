/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.etracker;

/**
 *
 * @author Ali
 */
public class TrackingInfo {
    
    private String driverName;
    private String timezone;
    private String vehicleRego;
    private String city;
    private double latitude;
    private double langitude;

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

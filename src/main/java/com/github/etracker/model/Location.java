/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.etracker.model;

import java.io.Serializable;
import javax.persistence.Embeddable;
import com.github.etracker.TimeZoneMapper;

/**
 *
 * @author Ali
 */
@Embeddable
public class Location implements Serializable {
    private double latitude;
    private double langitude;
    private String city;
//    private String country;
    private String timezone;

    public Location() {
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
    public String getTimezone() {
        return timezone;
    }
    public void setTimezone() {
        timezone = TimeZoneMapper.latLngToTimezoneString(latitude, langitude);
//        if(latitude > 0 && langitude > 0) {
//            return timezone = TimeZoneMapper.latLngToTimezoneString(latitude, langitude);
//        } else {
//            return "";
//        }
    }

    public Location(double latitude, double langitude, String city) {
        this.latitude = latitude;
        this.langitude = langitude;
        this.city = city;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.etracker.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Ali
 */
@Entity
@Table(name="vehicle")
@NamedQueries({
    @NamedQuery(name = "Vehicle.findAll", query = "SELECT v FROM Vehicle v"),
    @NamedQuery(name = "Vehicle.findByVehicleId", query = "SELECT c FROM Vehicle c WHERE c.id = :vehicleId"),
    @NamedQuery(name = "Vehicle.findByRego", query = "SELECT c FROM Vehicle c WHERE c.rego = :rego")})
    public class Vehicle implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String rego;
    private String makeModel;
    private Location location;
    @OneToOne(fetch = FetchType.EAGER)
    private Driver driver;

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Vehicle() {
    }

    public Vehicle(String rego, String makeModel) {
        this.rego = rego; 
        this.makeModel = makeModel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRego() {
        return rego;
    }

    public void setRego(String rego) {
        this.rego = rego;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}

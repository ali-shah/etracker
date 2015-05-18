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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ali
 */
@Entity
@Table(name="driver")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Driver.findAll", query = "SELECT c FROM Driver c"),
    @NamedQuery(name = "Driver.findByDriverId", query = "SELECT c FROM Driver c WHERE c.id = :driverId"),
    @NamedQuery(name = "Driver.findByName", query = "SELECT c FROM Driver c WHERE c.firstName = :name")
    })
public class Driver implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    public Driver(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    private String firstName;
    private String lastName;
    @OneToOne(fetch=FetchType.EAGER) 
    private Vehicle vehicle;
    private int age;

    public Driver() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}

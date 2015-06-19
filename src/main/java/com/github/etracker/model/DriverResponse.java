package com.github.etracker.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ali
 */
public class DriverResponse {
    private int id;
    private String firstName;
    private String lastName;
    private Vehicle vehicle;
    private int age;
    private List<Link> links; 
    private String rego;

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

    public String getRego() {
        return rego;
    }
    
    public void setRego(String rego) {
        this.rego = rego;
    }
}

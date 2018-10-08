package com.capgemini.webapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Airplane {

    // fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int fuelLoad = 5;
    private int airport;


    // methods
    public void refuel() {
        setFuelLoad(5);
    }



    // setters and getters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFuelLoad() {
        return fuelLoad;
    }

    public void setFuelLoad(int fuelLoad) {
        this.fuelLoad = fuelLoad;
    }

    public int getAirport() {
        return airport;
    }

    public void setAirport(int airport) {
        this.airport = airport;
    }
}

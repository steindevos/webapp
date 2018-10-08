package com.capgemini.webapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Airplane {

    // fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int fuelLoad = 5;

    @ManyToOne
    @NotNull
    private Airport airport;


    // methods

    // constructor
    public Airplane(){};

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

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }
}

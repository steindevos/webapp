package com.capgemini.webapp.controller;


import com.capgemini.webapp.model.Airport;
import com.capgemini.webapp.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/airport/")
public class AirportController {

    @Autowired
    private AirportRepository airportRepository;

    // GET request
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Airport> findAll() {
        return airportRepository.findAll();
    }

    // POST request
    @RequestMapping(method = RequestMethod.POST)
    public Airport create(@RequestBody Airport airport) {
        return airportRepository.save(airport);
    }

    // GET single airport
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Optional<Airport> findById(@PathVariable long id) {
        Optional<Airport> result = airportRepository.findById(id);
        return result;
    }



}

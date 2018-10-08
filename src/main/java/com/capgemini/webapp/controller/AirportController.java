package com.capgemini.webapp.controller;


import com.capgemini.webapp.model.Airport;
import com.capgemini.webapp.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}

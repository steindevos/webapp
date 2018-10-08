package com.capgemini.webapp.controller;

import com.capgemini.webapp.model.Airplane;
import com.capgemini.webapp.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/airplane/")
public class AirplaneController {


    @Autowired
    private AirplaneRepository airplaneRepository;

    // GET request
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Airplane> getAll() {
        return airplaneRepository.findAll();
    }

    // POST request
    @RequestMapping(method = RequestMethod.POST)
    public Airplane create(@RequestBody Airplane airplane) {
        return airplaneRepository.save(airplane);
    }
}

package com.capgemini.webapp.controller;

import com.capgemini.webapp.model.Airplane;
import com.capgemini.webapp.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    // UPDATE request
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Airplane updateById(@PathVariable long id, @RequestBody Airplane airplane) {
        if(airplaneRepository.existsById(id)){
            airplane.setId(id);
            airplane.flight();
            return airplaneRepository.save(airplane);
        } else {
            throw new RuntimeException();
        }
    }

}

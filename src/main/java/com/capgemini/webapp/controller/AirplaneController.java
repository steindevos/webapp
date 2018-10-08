package com.capgemini.webapp.controller;

import com.capgemini.webapp.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/airplane/")
public class AirplaneController {


    @Autowired
    private AirplaneRepository airplaneRepository;

    
}

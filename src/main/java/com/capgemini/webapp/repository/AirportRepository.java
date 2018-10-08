package com.capgemini.webapp.repository;

import com.capgemini.webapp.model.Airport;
import org.springframework.data.repository.CrudRepository;

public interface AirportRepository extends CrudRepository<Airport, Long > {
}

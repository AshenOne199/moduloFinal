package com.admin.aerolinea.services;

import com.admin.aerolinea.entity.Airline;
import com.admin.aerolinea.repository.IAirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirlineService {

    private final IAirlineRepository airlineRepository;

    @Autowired
    public AirlineService(IAirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    public List<Airline> getAirlines(){
        return airlineRepository.findAll();
    }


}

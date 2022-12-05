package com.admin.aerolinea.services;

import com.admin.aerolinea.repository.IFlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    private final IFlightRepository flightRepository;

    @Autowired
    public FlightService(IFlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public String getNumeroVuelo(String airlineCode){
        return airlineCode;
    }

}

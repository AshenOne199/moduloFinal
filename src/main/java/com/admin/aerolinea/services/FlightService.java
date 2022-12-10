package com.admin.aerolinea.services;

import com.admin.aerolinea.entity.Flight;
import com.admin.aerolinea.entity.FlightId;
import com.admin.aerolinea.repository.IFlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class FlightService {

    private final IFlightRepository flightRepository;

    @Autowired
    public FlightService(IFlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public String getFlightNumber(String airlineCode){
        return flightRepository.findByAirlineCode(airlineCode);
    }

    public Optional<Flight> findById(String flightNumber, String airlineCode) {
        return flightRepository.findById(flightNumber, airlineCode);
    }

    public Flight nuevoFlight(FlightId flightId) {
        return flightRepository.save(new Flight(flightId));
    }
}


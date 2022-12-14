package com.admin.aerolinea.services;

import com.admin.aerolinea.entity.Airport;
import com.admin.aerolinea.repository.IAirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AiportService {

    private final IAirportRepository airportRepository;

    @Autowired
    public AiportService(IAirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<Airport> getAiports(){
        return airportRepository.findAll();
    }

}

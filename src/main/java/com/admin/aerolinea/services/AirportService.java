package com.admin.aerolinea.services;

import com.admin.aerolinea.entity.Airport;
import com.admin.aerolinea.entity.AirportType;
import com.admin.aerolinea.repository.IAirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {

    public final IAirportRepository airportRepository;

    @Autowired
    public AirportService(IAirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }


    public List<Airport> getAirports(){
        return airportRepository.findAll();
    }


    public List<String> getNameAirport(String idPlaceAirport) {
        return airportRepository.findAirportNameByIdPlaceAiport(idPlaceAirport);
    }


    public List<String> getIdPlaceAirport() {
        return airportRepository.findAllIdPlaceAirport();
    }

    public List<Airport> findAll() {
        return airportRepository.findAll();
    }
}

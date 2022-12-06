package com.admin.aerolinea.services;

import com.admin.aerolinea.entity.AirportType;
import com.admin.aerolinea.repository.IAirportTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportTypeService {

    private final IAirportTypeRepository airportTypeRepository;

    @Autowired
    public AirportTypeService(IAirportTypeRepository airportTypeRepository) {
        this.airportTypeRepository = airportTypeRepository;
    }


    public List<AirportType> getAiportTypes(){
        return airportTypeRepository.findAll();
    }

}

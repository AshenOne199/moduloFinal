package com.admin.aerolinea.controllers;

import com.admin.aerolinea.entity.AirportType;
import com.admin.aerolinea.repository.IFlightRepository;
import com.admin.aerolinea.services.AirlineService;
import com.admin.aerolinea.services.AirportService;
import com.admin.aerolinea.services.AirportTypeService;
import com.admin.aerolinea.services.FlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ControllerVuelo {

    @Autowired
    private AirlineService airlineService;

    @Autowired
    private AirportService airportService;

    @Autowired
    private AirportTypeService airportTypeService;

    @Autowired
    private IFlightRepository flightRepository;

    @GetMapping("nuevoVuelo/aerolineas")
    public Map<String, Object> enviarAerolineas(){

        Map<String, Object> result = new HashMap<>();

        result.put("airlines", airlineService.getAirlines());

        return result;
    }

    @GetMapping("nuevoVuelo/aeropuertos")
    public Map<String, Object> enviarAeropuertos(){

        Map<String, Object> result = new HashMap<>();

        result.put("airports", airportService.getAirports());

        return result;
    }

    @GetMapping("nuevoVuelo/tiposAeropuertos")
    public Map<String, Object> enviarTiposAeropuertos(){

        Map<String, Object> result = new HashMap<>();

        result.put("airportTypes", airportTypeService.getAiportTypes());

        return result;
    }

    @GetMapping("nuevoVuelo/vuelos")
    public Map<String, Object> enviarVuelos(){

        Map<String, Object> result = new HashMap<>();

        result.put("flights", flightRepository.findAll());

        return result;
    }





}

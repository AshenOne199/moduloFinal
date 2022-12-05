package com.admin.aerolinea.controllers;

import com.admin.aerolinea.entity.Airline;
import com.admin.aerolinea.services.AirlineService;
import com.admin.aerolinea.services.FlightService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ControllerVuelo {

    Logger logger = LoggerFactory.getLogger(ControllerVuelo.class);

    @Autowired
    private AirlineService airlineService;

    @Autowired
    private FlightService flightService;

    @GetMapping("nuevoVuelo/aerolinea")
    public Optional<Object[]> habilitarAerolinea(){
        return airlineService.getAirlineNames();
    }

    @GetMapping("nuevoVuelo/aerolineas")
    public Map<String, Object> habilitarAerolineas(){

        Map<String, Object> result = new HashMap<>();

        String idUltimaAerolinea = "";

        logger.info("Ultimo id aerolinea:" + idUltimaAerolinea);

        //int idFinal = Integer.parseInt(idUltimaAerolinea);

        //idUltimaAerolinea = String.valueOf(idFinal);

        result.put("codigo", "123");
        result.put("airline", airlineService.getAirlines());

        return result;
    }



}

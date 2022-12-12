package com.admin.aerolinea.controllers;

import com.admin.aerolinea.services.AirportService;
import com.admin.aerolinea.services.ConnectionService;
import com.admin.aerolinea.services.FlightSegmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ControllerItirenario {

    Logger logger = LoggerFactory.getLogger(ControllerVuelo.class);

    @Autowired
    private AirportService airportService;

    @Autowired
    private FlightSegmentService flightSegmentService;

    @Autowired
    private ConnectionService connectionService;

    @GetMapping("aeropuertos")
    public Map<String, Object> getAllAiports(){

        Map<String, Object> result = new HashMap<>();
        result.put("aiports", airportService.getAllAirports());

        return result;
    }


    //Dado un AIPORTNAME  traer AIPORT
    //http://localhost:8080/api/nuevoVuelo/aerolineas/origen?airportName=Lester B. Pearson International Airport
    @GetMapping("nuevoVuelo/aerolineas/origen_destino")
    public Map<String, Object> getAiports(@RequestParam String airportName){

        logger.info("aiportName recibido: [" + airportName + "]");

        Map<String, Object> result = new HashMap<>();
        result.put("aiports", airportService.getAirportsByAirportName(airportName));

        return result;
    }

    //Dado un AIRPORTCODE   traer FLIGHTSEGMENT
    //http://localhost:8080/api/nuevoVuelo/aerolineas/aiportCode_flightSegment?airportCode=YYZ
    @GetMapping("nuevoVuelo/aerolineas/aiportCode_flightSegment")
    public Map<String, Object> getFlightSegments(@RequestParam String airportCode){

        logger.info("aiportCode recibido: [" + airportCode + "]");

        Map<String, Object> result = new HashMap<>();
        result.put("flightSegment", flightSegmentService.findByAirportCode(airportCode));

        return result;
    }

    //Dado un AIRPORTCODE y un IDVUELO  traer FLIGHTSEGMENT
    //http://localhost:8080/api/nuevoVuelo/aerolineas/aiportCodeIdVuelo_flightSegment?airporCode=MDZ&idTrayecto=1
    @GetMapping("nuevoVuelo/aerolineas/aiportCodeIdVuelo_flightSegment")
    public Map<String, Object> getFlightSegments(@RequestParam String airportCode, @RequestParam String idTrayecto){

        logger.info("aiportCode e idTrayecto recibido: [" + airportCode + "], [" + idTrayecto + "]");

        Map<String, Object> result = new HashMap<>();
        result.put("flightSegment", flightSegmentService.findByAirportCodeAndIdTrayecto(airportCode, idTrayecto));

        return result;
    }

    //Dado un IDVUELO  traer FLIGHTSEGMENT
    //http://localhost:8080/api/nuevoVuelo/aerolineas/IdVuelo_flightSegment?idTrayecto=1
    @GetMapping("nuevoVuelo/aerolineas/IdVuelo_flightSegment")
    public Map<String, Object> getFlightSegmentsTrayecto(@RequestParam String idTrayecto){

        logger.info("aiportCode recibido: [" + idTrayecto + "]");

        Map<String, Object> result = new HashMap<>();
        result.put("flightSegment", flightSegmentService.findByIdTrayecto(idTrayecto));

        return result;
    }

    //Consultar conexiones
    //http://localhost:8080/api/nuevoVuelo/aerolineas/conexiones?origenAirlineCode=XXX&origenFlightNumber=XXX&origenAirportCodeDestino=XXX&origenIdSegment=XXX
    @GetMapping("nuevoVuelo/aerolineas/conexiones")
    public Map<String, Object> getConexiones(@RequestParam String origenAirlineCode, @RequestParam String origenFlightNumber, @RequestParam String origenAirportCodeDestino, @RequestParam String origenIdSegment){

        Map<String, Object> result = new HashMap<>();
        result.put("flightSegment", connectionService.findConections(origenAirlineCode, origenFlightNumber, origenAirportCodeDestino, origenIdSegment));

        return result;
    }


}

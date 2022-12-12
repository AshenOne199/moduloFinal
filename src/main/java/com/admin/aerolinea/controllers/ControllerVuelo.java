package com.admin.aerolinea.controllers;

import com.admin.aerolinea.entity.*;
import com.admin.aerolinea.services.*;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class ControllerVuelo {

    Logger logger = LoggerFactory.getLogger(ControllerVuelo.class);

    @Autowired
    private AirlineService airlineService;

    @Autowired
    private AirportService airportService;

    @Autowired
    private AirportTypeService airportTypeService;
    @Autowired
    private FlightService flightService;

    @Autowired
    private PlaceService placeService;

    @Autowired
    private PilotService pilotService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PersonService personService;

    @Autowired
    private FlightSegmentService flightSegmentService;

    //Listar todas las aerolineas
    //http://localhost:8080/api/nuevoVuelo/aerolineas
    @GetMapping("nuevoVuelo/aerolineas")
    public Map<String, Object> getAerolineas(){

        Map<String, Object> result = new HashMap<>();

        result.put("airlines", airlineService.getAirlines());

        return result;
    }

    //Dado un airlineName retorna airlineCode de Airline
    //http://localhost:8080/api/nuevoVuelo/aerolineas/airlineName?airlineName=Avianca
    @GetMapping("nuevoVuelo/aerolineas/airlineName")
    public Map<String, Object> recibirAerolinea(@RequestParam String airlineName){
        logger.info("Aerolinea recibida: [" + airlineName + "]");

        Map<String, Object> result = new HashMap<>();
        result.put("airlineCode", airlineService.getAirlineCode(airlineName));

        return result;
    }

    //-------------------------------------------------------Avance 1---------------------------------------------------
    //Dado un airlineCode retorna flightNumber de Flight
    //http://localhost:8080/api/nuevoVuelo/aerolineas/airlineCode_flightNumber?airlineCode=W3
    @GetMapping("nuevoVuelo/aerolineas/airlineCode_flightNumber")
    public Map<String, Object> getNumeroVuelo(@RequestParam String airlineCode){

        logger.info("airlineCode recibido: [" + airlineCode + "]");

        Map<String, Object> result = new HashMap<>();
        result.put("flightNumber", flightService.getFlightNumber(airlineCode));

        return result;
    }

    //Retornar el último id segment
    //http://localhost:8080/api/nuevoVuelo/aerolineas/segmento
    @GetMapping("nuevoVuelo/aerolineas/segmento")
    public Map<String, Object> getIdSegmento(){

        Map<String, Object> result = new HashMap<>();
        result.put("segmentNumber", flightSegmentService.getSegmento());

        return result;
    }

    //http://localhost:8080/api/nuevoVuelo/aerolineas/trayecto
    @GetMapping("nuevoVuelo/aerolineas/trayecto")
    public Map<String, Object> getIdTrayecto(){

        Map<String, Object> result = new HashMap<>();
        result.put("journeyNumber", flightSegmentService.getTrayecto());

        return result;
    }

    //Dado un airlineCode retorna idPlace de Flight
    //http://localhost:8080/api/nuevoVuelo/aerolineas/airlineCode_idPlace?airlineCode=W3
    @GetMapping("nuevoVuelo/aerolineas/airlineCode_idPlace")
    public Map<String, Object> getIdLugarAerolinea(@RequestParam String airlineCode){

        logger.info("airlineCode recibido: [" + airlineCode + "]");

        Map<String, Object> result = new HashMap<>();
        result.put("idPlace", airlineService.getIdPlace(airlineCode));

        return result;
    }

    //Dado un pais_FK retorna el idPlace del lugar
    //http://localhost:8080/api/nuevoVuelo/aerolineas/paisFK_idPlace?pais=ESP
    @GetMapping("nuevoVuelo/aerolineas/paisFK_idPlace")
    public Map<String, Object> getIdLugar(@RequestParam String pais){

        logger.info("Pais recibido: [" + pais + "]");

        Map<String, Object> result = new HashMap<>();
        result.put("idPlace", placeService.getIdPlaceByPais(pais));

        return result;
    }

    //Dado un idPlaceAirport retorna el nombre del aeropuesto
    //http://localhost:8080/api/nuevoVuelo/aerolineas/idPlace_aiportName?idPlaceAirport=ON_D
    @GetMapping("nuevoVuelo/aerolineas/idPlace_aiportName")
    public Map<String, Object> getNombreAeropuerto(@RequestParam String idPlaceAirport){

        logger.info("Pais del aeropuerto recibido: [" + idPlaceAirport + "]");

        Map<String, Object> result = new HashMap<>();
        result.put("nameAirport", airportService.getNameAirport(idPlaceAirport));

        return result;
    }

    //Dado un pais retorna el nombre de los aeropuertos de ese pais - ESTA ERA LA PRUEBA XD
    //http://localhost:8080/api/nuevoVuelo/aerolineas/pais_airpotName?pais=ESP
    @GetMapping("nuevoVuelo/aerolineas/pais_airpotName")
    public Map<String, Object> getNombreAeropuertos(@RequestParam String pais){

        logger.info("Pais recibido: [" + pais + "]");

        List<String> result = airportService.getIdPlaceAirport();
        logger.info("allIdPlace: " + result);

        List<String> result2 = placeService.getIdPlaceByPais(pais);
        logger.info("IdPlace seleccionado: " + result2);


        List<String> idPlacesCorrectos = new ArrayList<>();
        for (String allIdPlace : result){
            for(String idPlace : result2){
                if(allIdPlace.equalsIgnoreCase(idPlace)){
                    idPlacesCorrectos.add(allIdPlace);
                }
            }
        }

        Map<String, Object> resultadoFinal = new HashMap<>();
        resultadoFinal.put("idPlaces", idPlacesCorrectos);
        resultadoFinal.put("airlines", airportService.findAll());

        logger.info("Resultado final: " + resultadoFinal);

        return resultadoFinal;
    }

    //Dado un AIRLINECODEPILOTFK retorna el EMPLOYEENUMBERPILOTFK del piloto
    //http://localhost:8080/api/nuevoVuelo/aerolineas/airlineCode_pilot?airlineCode=W3
    @GetMapping("nuevoVuelo/aerolineas/airlineCode_pilot")
    public Map<String, Object> getPilotoAerolinea(@RequestParam String airlineCode){

        logger.info("AirlineCode: [" + airlineCode + "]");

        Map<String, Object> result = new HashMap<>();
        result.put("employeeNumber", pilotService.getEmployeeNumber(airlineCode));

        return result;
    }

    //Dado un EMPLOYEENUMBER  retorna el IDPERSONEMPLOYEEFK  del Empleado
    //http://localhost:8080/api/nuevoVuelo/aerolineas/employeeNumber_idPerson?employeeNumber=E1
    @GetMapping("nuevoVuelo/aerolineas/employeeNumber_idPerson")
    public Map<String, Object> getNumeroEmpleado(@RequestParam String employeeNumber){

        logger.info("Número empleado: [" + employeeNumber + "]");

        Map<String, Object> result = new HashMap<>();
        result.put("idPerson", employeeService.getIdPerson(employeeNumber));


        return result;
    }

    //Dado un idPerson traer al Piloto
    //http://localhost:8080/api/nuevoVuelo/aerolineas/idPerson_piloto?idPerson=1128388325
    @GetMapping("nuevoVuelo/aerolineas/idPerson_piloto")
    public Map<String, Object> getPiloto(@RequestParam String idPerson){

        logger.info("IdPerson: [" + idPerson + "]");

        Map<String, Object> result = new HashMap<>();
        result.put("piloto", personService.getNames(idPerson));

        return result;
    }

    //Dado un Id traer Place
    //http://localhost:8080/api/nuevoVuelo/aerolineas/id_place?idPlace=GR_D
    @GetMapping("nuevoVuelo/aerolineas/id_place")
    public Map<String, Object> getPlaces(@RequestParam String idPlace){

        logger.info("IdPlace: [" + idPlace + "]");

        Map<String, Object> result = new HashMap<>();
        result.put("place", placeService.getById(idPlace));

        return result;
    }

    //Dado un AIPORTNAME  traer división
    //http://localhost:8080/api/nuevoVuelo/aerolineas/aiportName_airport?airportName=Lester B. Pearson International Airport
    @GetMapping("nuevoVuelo/aerolineas/aiportName_airport")
    public Map<String, Object> getAiports(@RequestParam String airportName){

        logger.info("aiportName recibido: [" + airportName + "]");

        Map<String, Object> result = new HashMap<>();
        result.put("aiports", airportService.getAirportsByAirportName(airportName));

        return result;
    }

    //Dado un AIPORTNAME  traer codigo aeropuertp
    //http://localhost:8080/api/nuevoVuelo/aerolineas/aiportName_aiportCode?airportName=Lester B. Pearson International Airport
    @GetMapping("nuevoVuelo/aerolineas/aiportName_airportCode")
    public Map<String, Object> getAiportCode(@RequestParam String airportName){

        logger.info("aiportName recibido: [" + airportName + "]");

        Map<String, Object> result = new HashMap<>();
        result.put("aiports", airportService.getAirportCode(airportName));

        return result;
    }



    //Dado un IDPLACE   traer PLACENAME de PLACE
    //http://localhost:8080/api/nuevoVuelo/aerolineas/idPLace_PlaceName?idPlace=CAN
    @GetMapping("nuevoVuelo/aerolineas/idPLace_PlaceName")
    public Map<String, Object> getPlaceName(@RequestParam String idPlace){

        logger.info("idPlace: [" + idPlace + "]");

        Map<String, Object> result = new HashMap<>();
        result.put("placeNames", placeService.getPlaceNames(idPlace));

        return result;
    }






}

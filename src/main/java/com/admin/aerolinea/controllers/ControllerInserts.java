package com.admin.aerolinea.controllers;

import com.admin.aerolinea.entity.*;
import com.admin.aerolinea.services.ConnectionService;
import com.admin.aerolinea.services.FlightSegmentService;
import com.admin.aerolinea.services.FlightService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ControllerInserts {

    Logger logger = LoggerFactory.getLogger(ControllerVuelo.class);

    @Autowired
    private FlightService flightService;

    @Autowired
    private FlightSegmentService flightSegmentService;

    @Autowired
    private ConnectionService connectionService;


    //Post para crear Flight. Ej:
    /*
        {
            "flightNumber":"129",
            "airlineCode":"W3"
        }
    */
    // api/insertFlight
    @Transactional
    @PostMapping("insertFlight")
    public ResponseEntity<?> insertFlight(@Valid @RequestBody FlightId flightId){

        logger.info("RequestBody FlightId: " + flightId.toString());

        Optional<Flight> newFlight = flightService.findById(flightId.getFlightNumber(), flightId.getAirlineCode());

        if(newFlight.isEmpty()){
            try {
                flightService.nuevoFlight(new FlightId(flightId.getFlightNumber(), flightId.getAirlineCode()));
            }catch (Exception e){
                logger.info("Error al realizar insert: " + e);
            }


            return  ResponseEntity.status(HttpStatus.OK).body("Nuevo registro realizado");
        }

        return ResponseEntity.status(HttpStatus.CONFLICT).body("El Id ya esta registrado");
    }

    //POST  para crear FlightSegment
    /*
    {
            "flightSegmentId": {
               "idSegment":"XXX",
                "airlineCode":"XXX",
                "flightNumber":"XXX",
               "airportCodeDestino":"XXX"
        },
        "aiportCodeOrigen":"XXX".
        "idTrayecto":"XXX"
    }
     */

    @PostMapping("insertFilghtSegment")
    public ResponseEntity<?> insertFlightSegment(@RequestBody FlightSegment flightSegment){

        logger.info("RequestBody FlightId: " + flightSegment.toString());


        Optional<FlightSegment> newSegmento = flightSegmentService.findByIds(flightSegment.getFlightSegmentId());

        if(!newSegmento.isEmpty()){


            logger.info("ID recibido: " + flightSegment.getFlightSegmentId().getIdSegment());


            int id = Integer.parseInt(flightSegment.getFlightSegmentId().getIdSegment()) + 1;
            String idIncrementado = Integer.toString(id);
            logger.info("Nuevo ID a insertar: " + idIncrementado);

            try{
                flightSegmentService.nuevoSegmento(new FlightSegment(
                        new FlightSegmentId(idIncrementado,
                                flightSegment.getFlightSegmentId().getAirlineCode(),
                                flightSegment.getFlightSegmentId().getFlightNumber(),
                                flightSegment.getFlightSegmentId().getAirportCodeDestino()),
                        flightSegment.getAiportCodeOrigen(), flightSegment.getIdTrayecto()));
            }catch (Exception e){
                logger.info("Error al realizar insert: " + e);
            }
            return  ResponseEntity.status(HttpStatus.OK).body("Nuevo registro realizado");
        }

        return ResponseEntity.status(HttpStatus.CONFLICT).body("El Id ya esta registrado");
    }

    //POST para crear Connection
    /*
    {
        "idConexiones":"1",
        "origenAirlineCode":"XXX",
        "origenFlightNumber":"XXX",
        "origenAirportCodeDestino":"XXX",
        "origenIdSegment":"XXX",
        "destinoAirlineCode":"XXX",
        "destinoFlightNumber":"XXX",
        "destinoAirportCode":"XXX",
        "destinoIdSegment":"XXX"
    }
     */

    @PostMapping("insertConnection")
    public ResponseEntity<?> insertConnection(@RequestBody Connection connection){


        logger.info("ID recibido de Connection: " + connection.getIdConexiones());
        Optional<Connection> newConnection = connectionService.findById(connection.getIdConexiones());

        if(newConnection.isEmpty()){

            int id = Integer.parseInt(connection.getDestinoIdSegment()) + 1;
            String idIncrementado = Integer.toString(id);
            logger.info("Nuevo ID a insertar: " + idIncrementado);
            connection.setOrigenIdSegment(idIncrementado);
            connection.setDestinoIdSegment(idIncrementado);

            try {
                logger.info("RequestBody Connection: " + connection.toString());
                connectionService.nuevaConexion(connection);
            }catch (Exception e){
                logger.info("Error al realizar insert: " + e);
                return  ResponseEntity.status(HttpStatus.CONFLICT).body("Erro al hacer insert");
            }
            return  ResponseEntity.status(HttpStatus.OK).body("Nuevo registro realizado");
        }

        return ResponseEntity.status(HttpStatus.CONFLICT).body("El Id ya esta registrado");
    }
}

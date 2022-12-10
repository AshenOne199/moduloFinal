package com.admin.aerolinea.services;

import com.admin.aerolinea.entity.FlightId;
import com.admin.aerolinea.entity.FlightSegmentId;
import com.admin.aerolinea.entity.Flightsegment;
import com.admin.aerolinea.repository.IFlightSegmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FlightSegmentService {

    private final IFlightSegmentRepository flightSegmentRepository;

    @Autowired
    public FlightSegmentService(IFlightSegmentRepository flightSegmentRepository) {
        this.flightSegmentRepository = flightSegmentRepository;
    }

    //public Optional<Flightsegment> findById(FlightSegmentId flightSegmentId, String aiportCodeOrigen) {
  //      return flightSegmentRepository.findById(flightSegmentId.getIdSegment(), flightSegmentId.getAirlineCode(), flightSegmentId.getFlightNumber(), flightSegmentId.getAirportCodeDestino(), aiportCodeOrigen);
    //}

}

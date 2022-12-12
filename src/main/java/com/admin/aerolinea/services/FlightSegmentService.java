package com.admin.aerolinea.services;

import com.admin.aerolinea.entity.FlightSegment;
import com.admin.aerolinea.entity.FlightSegmentId;
import com.admin.aerolinea.repository.IFlightSegmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightSegmentService {

    private final IFlightSegmentRepository flightSegmentRepository;

    @Autowired
    public FlightSegmentService(IFlightSegmentRepository flightSegmentRepository) {
        this.flightSegmentRepository = flightSegmentRepository;
    }


    public Optional<FlightSegment> findByIds(FlightSegmentId flightSegmentId) {
        return flightSegmentRepository.findIds(flightSegmentId.getIdSegment());
    }

    public FlightSegment nuevoSegmento(FlightSegment flightSegment) {
        return flightSegmentRepository.save(flightSegment);
    }

    public List<String> findByAirportCode(String airportCode) {
        return flightSegmentRepository.findByAiportCode(airportCode);
    }

    public List<String> findByAirportCodeAndIdTrayecto(String airportCode, String idTrayecto) {
        return flightSegmentRepository.findByAiportCodeAndIdtrayecto(airportCode, idTrayecto);
    }

    public List<String> findByIdTrayecto(String idTrayecto) {
        return flightSegmentRepository.findByIdTrayecto(idTrayecto);
    }

    public String getSegmento() {
        return  flightSegmentRepository.findIdSegmento();
    }

    public String getTrayecto() {
        return flightSegmentRepository.findIdTrayecto();
    }
}

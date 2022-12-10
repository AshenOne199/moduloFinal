package com.admin.aerolinea.repository;

import com.admin.aerolinea.entity.FlightSegmentId;
import com.admin.aerolinea.entity.Flightsegment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IFlightSegmentRepository extends JpaRepository<Flightsegment, FlightSegmentId> {

    //@Query(value = "SELECT f FROM Flightsegment f WHERE f.flightSegmentId.idSegment = ?1,  f.flightSegmentId.airlineCode = ?2, f.flightSegmentId.flightNumber = ?3, f.flightSegmentId.airportCodeDestino = ?4, f.aiportCodeOrigen = ?5")
    //Optional<Flightsegment> findById(String idSegment, String airlineCode, String flightNumber, String airportCodeDestino, String aiportCodeOrigen);
}

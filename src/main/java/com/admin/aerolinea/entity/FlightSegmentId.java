package com.admin.aerolinea.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class FlightSegmentId implements Serializable {

    @Column(name = "IDSEGMENT", nullable = false)
    private String idSegment;

    @Column(name = "AIRLINECODESEGMENTFK", nullable = false)
    private String airlineCode;

    @Column(name = "FLIGHTNUMBERSEGMENTFK", nullable = false)
    private String flightNumber;

    @Column(name = "AIRPORTCODEDESTINOFK", nullable = false)
    private String airportCodeDestino;

}

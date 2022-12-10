package com.admin.aerolinea.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
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

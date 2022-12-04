package com.admin.aerolinea.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;


@Embeddable
public class FlightId implements Serializable {


    @Column(name = "FLIGHTNUMBER")
    private String flightsegments;

    @Column(name = "AIRLINECODEFK", nullable = false)
    private String airlineCode;

}

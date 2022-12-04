package com.admin.aerolinea.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class PilotassgimentId {

    @Column(name = "IDPILOTASSGIMENT", nullable = false)
    private String idPilotAssigment;

    @Column(name = "AIRLINECODESEGMENT_PILOTFK", nullable = false)
    private String airlineCodeSegment;

    @Column(name = "FLIGHTNUMBERSEGMENT_PILOTFK", nullable = false)
    private String flightNumberSegment;

    @Column(name = "AIRPORTCODEDESTINO_PILOTFK", nullable = false)
    private String airportCodeDestino;

    @Column(name = "IDSEGMENTFK", nullable = false)
    private String idSegment;

    @Column(name = "PILOTLICENSEFK", nullable = false)
    private String pilotLicense;



}

package com.admin.aerolinea.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "FLIGHTSEGMENT")
public class Flightsegment {

    @EmbeddedId
    FlightSegmentId flightSegmentId;

    @Column(name = "AIRPORTCODEORIGENFK", nullable = false)
    private String aiportCodeOrigen;

}
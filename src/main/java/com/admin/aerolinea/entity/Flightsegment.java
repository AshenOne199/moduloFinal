package com.admin.aerolinea.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FLIGHTSEGMENT")
public class Flightsegment {

    @EmbeddedId
    FlightSegmentId flightSegmentId;

    @Column(name = "AIRPORTCODEORIGENFK", nullable = false)
    private String aiportCodeOrigen;

}
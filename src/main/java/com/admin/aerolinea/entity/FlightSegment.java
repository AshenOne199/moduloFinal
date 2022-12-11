package com.admin.aerolinea.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FLIGHTSEGMENT")
public class FlightSegment {

    @EmbeddedId
    FlightSegmentId flightSegmentId;

    @Column(name = "AIRPORTCODEORIGENFK", nullable = false)
    private String aiportCodeOrigen;

    @Column(name = "IDTRAYECTO", nullable = false)
    private String idTrayecto;

}
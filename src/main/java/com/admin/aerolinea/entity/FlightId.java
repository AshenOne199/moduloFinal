package com.admin.aerolinea.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class FlightId implements Serializable {


    @Column(name = "FLIGHTNUMBER")
    private String flightsegments;

    @Column(name = "AIRLINECODEFK", nullable = false)
    private String airlineCode;

}

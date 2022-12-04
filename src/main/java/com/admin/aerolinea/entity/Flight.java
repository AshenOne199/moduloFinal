package com.admin.aerolinea.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "FLIGHT")
public class Flight {

    @EmbeddedId
    FlightId flightId;

}
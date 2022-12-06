package com.admin.aerolinea.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "FLIGHT")
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

    @EmbeddedId
    FlightId flightId;


}
package com.admin.aerolinea.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "AIRLINE")
public class Airline {

    @Id
    @Column(name = "AIRLINECODE", nullable = false)
    private String airlineCode;

    @Column(name = "IDPLACEAIRLINEFK")
    private String idPlaceAirlineFk;

    @Column(name = "AIRLINENAME", nullable = false)
    private String airlineName;



}
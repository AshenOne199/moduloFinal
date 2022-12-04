package com.admin.aerolinea.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "AIRPORTTYPE")
public class AirportType {

    @Id
    @Column(name = "AIRPORTTYPE", nullable = false)
    private String aiportType;

    @Column(name = "DESCTYPE", nullable = false)
    private String descType;

}
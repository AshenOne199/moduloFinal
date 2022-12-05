package com.admin.aerolinea.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "AIPORT")
public class Airport {

    @Id
    @Column(name = "AIRPORTCODE", nullable = false)
    private String aiportCode;

    @Column(name = "IDPLACEAIRPORTFK")
    private String idPlace;

    @Column(name = "AIRPORTTYPEFK", nullable = false)
    private String aiportType;

    @Column(name = "AIPORTNAME", nullable = false)
    private String aiportName;

}
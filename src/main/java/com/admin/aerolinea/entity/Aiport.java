package com.admin.aerolinea.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "AIPORT")
public class Aiport {

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
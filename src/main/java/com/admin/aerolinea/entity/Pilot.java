package com.admin.aerolinea.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "PILOT")
public class Pilot {

    @Id
    @Column(name = "PILOTLICENSE", nullable = false)
    private String pilotLicense;

    @Column(name = "AIRLINECODEPILOTFK")
    private String airlineCode;

    @Column(name = "EMPLOYEENUMBERPILOTFK")
    private String employeeNumber;

    @Column(name = "PLIOTLICENSEEXPIRATION", nullable = false)
    private LocalDate pilotLicenseExpiration;


}
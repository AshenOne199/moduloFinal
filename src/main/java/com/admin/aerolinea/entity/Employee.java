package com.admin.aerolinea.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @EmbeddedId
    private EmployeeId employeeId;

    @Column(name = "IDPERSONEMPLOYEEFK")
    private String idPersonEmployee;

    @NotNull
    @Column(name = "DATEHIRED", nullable = false)
    private LocalDate dateHired;

}
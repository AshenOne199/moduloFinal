package com.admin.aerolinea.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class EmployeeId implements Serializable {

    @Column(name = "EMPLOYEENUMBER", nullable = false)
    private String employeeNumber;

    @Column(name = "AIRLINECODE", nullable = false)
    private String airlineCode;

}

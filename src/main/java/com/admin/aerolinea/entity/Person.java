package com.admin.aerolinea.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "PERSON")
public class Person {

    @Id
    @Column(name = "IDPERSON", nullable = false)
    private String idPerson;

    @Column(name = "IDPLACEPERSONFK")
    private String idPlace;

    @Column(name = "FIRST_NAME")
    private String first_name;

    @Column(name = "LAST_NAME")
    private String last_name;





}
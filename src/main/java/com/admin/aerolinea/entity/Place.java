package com.admin.aerolinea.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "PLACE")
public class Place {
    @Id
    @Column(name = "IDPLACE", nullable = false)
    private String idPlace;


    @Column(name = "IDPLACETYPEFK", nullable = false)
    private String idPLaceTypeFk;

    @Column(name = "PAIS_FK", nullable = false)
    private String pais;

    @Column(name = "CIUDAD_FK", nullable = false)
    private String ciudad;

    @Column(name = "PLACENAME", nullable = false)
    private String placeName;


}
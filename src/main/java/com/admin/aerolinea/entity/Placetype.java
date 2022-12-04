package com.admin.aerolinea.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "PLACETYPE")
public class Placetype {

    @Id
    @Column(name = "IDPLACETYPE", nullable = false)
    private String idPlaceType;

    @Column(name = "DESPLACETYPE", nullable = false)
    private String descPlaceType;


}
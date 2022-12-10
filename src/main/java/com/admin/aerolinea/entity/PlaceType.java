package com.admin.aerolinea.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "PLACETYPE")
public class PlaceType {

    @Id
    @Column(name = "IDPLACETYPE", nullable = false)
    private String idPlaceType;

    @Column(name = "DESPLACETYPE", nullable = false)
    private String descPlaceType;


}
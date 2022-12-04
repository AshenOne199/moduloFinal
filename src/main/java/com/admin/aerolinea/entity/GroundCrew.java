package com.admin.aerolinea.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "GROUNCREW")
public class GroundCrew {

    @Id
    @Column(name = "IDCREW", nullable = false)
    private String idCrew;

    @Column(name = "IDPERSONCREWFK")
    private String idPersonCrew;

}

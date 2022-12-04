package com.admin.aerolinea.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "PASSANGER")
public class Passanger {

    @Id
    @Column(name = "IDPASSANGER", nullable = false)
    private String idPassanger;

    @Column(name = "IDPERSONPASSANGERFK")
    private String idPersonPassanger;

}
package com.admin.aerolinea.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PILOTASSGIMENT")
public class Pilotassgiment {

    @EmbeddedId
    PilotassgimentId pilotassgimentId;


}
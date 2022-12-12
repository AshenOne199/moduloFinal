package com.admin.aerolinea.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "CONNECTIONS")
public class Connection {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    @SequenceGenerator(sequenceName = "id_seq", allocationSize = 1, name = "CUST_SEQ")
    @Column(name = "IDCONEXIONES")
    private Long idConexiones;

    @Column(name = "ORIGEN_AIRLINECODESEGMENTFK")
    private String origenAirlineCode;

    @Column(name = "ORIGEN_FLIGHTNUMBERSEGMENTFK")
    private String origenFlightNumber;

    @Column(name = "ORIGENI_AIRPORTCODEDESTINOFK")
    private String origenAirportCodeDestino;

    @Column(name = "ORIGEN_IDSEGMENT")
    private String origenIdSegment;

    @Column(name = "DESTINO_AIRLINECODESEGMENTFK")
    private String destinoAirlineCode;

    @Column(name = "DESTINO_FLIGHTNUMBERSEGMENTFK")
    private String destinoFlightNumber;

    @Column(name = "DESTINO_AIRPORTCODEDESTINOFK")
    private String destinoAirportCode;

    @Column(name = "DESTINO_IDSEGMENT")
    private String destinoIdSegment;

}
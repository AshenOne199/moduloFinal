package com.admin.aerolinea.repository;

import com.admin.aerolinea.entity.Connection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IConnectionRepository extends JpaRepository<Connection, String> {

    @Query(value = "SELECT c FROM Connection c WHERE c.origenAirlineCode = ?1 AND c.origenFlightNumber = ?2 AND c.origenAirportCodeDestino = ?3 AND c.origenIdSegment = ?4")
    List<String> findConnection(String origenAirlineCode, String origenFlightNumber, String origenAirportCodeDestino, String origenIdSegment);

    @Query(value = "SELECT MAX(c.idConexiones) FROM Connection c")
    String findMaxId();

    @Query(value = "SELECT c FROM Connection c WHERE c.idConexiones = ?1")
    Optional<Connection> findByIds(Long idConexiones);
}

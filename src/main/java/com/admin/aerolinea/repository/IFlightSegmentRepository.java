package com.admin.aerolinea.repository;

import com.admin.aerolinea.entity.FlightSegmentId;
import com.admin.aerolinea.entity.FlightSegment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IFlightSegmentRepository extends JpaRepository<FlightSegment, FlightSegmentId> {

    @Query(value = "SELECT MAX(TO_NUMBER(f.flightSegmentId.idSegment)) FROM FlightSegment f WHERE f.flightSegmentId.idSegment=?1")
    Optional<FlightSegment> findIds(String idSegment);

    @Query(value = "SELECT f FROM FlightSegment f WHERE f.aiportCodeOrigen = ?1")
    List<FlightSegment> findByAiportCode(String airportCode);

    @Query(value = "SELECT f FROM FlightSegment f WHERE f.aiportCodeOrigen = ?1 AND f.idTrayecto = ?2")
    List<String> findByAiportCodeAndIdtrayecto(String airportCode, String idTrayecto);

    @Query(value = "SELECT f FROM FlightSegment f WHERE f.idTrayecto = ?1")
    List<String> findByIdTrayecto(String idTrayecto);
    @Query(value = "SELECT MAX(TO_NUMBER(f.flightSegmentId.idSegment)) FROM FlightSegment f")
    String findIdSegmento();

    @Query(value = "SELECT MAX(TO_NUMBER(f.idTrayecto)) FROM FlightSegment f")
    String findIdTrayecto();
}

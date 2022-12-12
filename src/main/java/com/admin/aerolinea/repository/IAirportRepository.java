package com.admin.aerolinea.repository;

import com.admin.aerolinea.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAirportRepository extends JpaRepository<Airport, String> {

    @Query(value = "SELECT aiportName FROM Airport WHERE idPlace = ?1")
    List<String> findAirportNameByIdPlaceAiport(String idPlaceAirport);

    @Query(value = "SELECT idPlace FROM Airport")
    List<String> findAllIdPlaceAirport();

    @Query(value = "SELECT idPlace FROM Airport WHERE aiportName = ?1")
    List<String> findByAirportName(String airportName);

    @Query(value = "SELECT aiportCode FROM Airport WHERE aiportName = ?1")
    String findAirportCode(String airportName);
}

package com.admin.aerolinea.repository;

import com.admin.aerolinea.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAirlineRepository extends JpaRepository<Airline, String> {
    @Query(value = "SELECT idPlaceAirlineFk FROM Airline WHERE airlineCode=?1")
    List<String> findByAirlineCodeIdPlace(String airlineCode);

    @Query(value = "SELECT airlineCode FROM Airline WHERE airlineName=?1")
    String findByAirlineNameAirlineCode(String airlineName);
}

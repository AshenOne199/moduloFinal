package com.admin.aerolinea.repository;

import com.admin.aerolinea.entity.Flight;
import com.admin.aerolinea.entity.FlightId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IFlightRepository extends JpaRepository<Flight, FlightId> {

    @Query(value = "SELECT MAX(f.flightId.flightNumber) FROM Flight f WHERE f.flightId.airlineCode = ?1")
    String findByAirlineCode(String airlineCode);

    @Query(value = "SELECT f FROM Flight f WHERE f.flightId.flightNumber = ?1 AND f.flightId.airlineCode = ?2")
    Optional<Flight> findById(String flightNumber, String airlineCode);
}

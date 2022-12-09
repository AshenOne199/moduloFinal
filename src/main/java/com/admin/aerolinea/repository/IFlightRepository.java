package com.admin.aerolinea.repository;

import com.admin.aerolinea.entity.Flight;
import com.admin.aerolinea.entity.FlightId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFlightRepository extends JpaRepository<Flight, FlightId> {

    @Query(value = "SELECT MAX(f.flightId.flightNumber) FROM Flight f WHERE f.flightId.airlineCode = ?1")
    String findByAirlineCode(String airlineCode);


}

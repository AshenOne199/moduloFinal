package com.admin.aerolinea.repository;

import com.admin.aerolinea.entity.Flight;
import com.admin.aerolinea.entity.FlightId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IFlightRepository extends JpaRepository<Flight, FlightId> {

    //@Query("SELECT MAX(FLIGHTNUMBER) FROM FLIGHT WHERE AIRLINECODE = ?1")
    //String getLastFlightNumber(String airlineCode);

}

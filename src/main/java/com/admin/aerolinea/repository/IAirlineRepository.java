package com.admin.aerolinea.repository;

import com.admin.aerolinea.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface IAirlineRepository extends JpaRepository<Airline, String> {

    @Query(value = "SELECT AIRLINENAME FROM AIRLINE", nativeQuery = true)
    Optional<Object[]> findAirlineName();


}

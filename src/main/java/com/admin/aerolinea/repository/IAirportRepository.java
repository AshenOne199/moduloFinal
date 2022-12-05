package com.admin.aerolinea.repository;

import com.admin.aerolinea.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAirportRepository extends JpaRepository<Airport, String> {



}

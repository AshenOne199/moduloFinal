package com.admin.aerolinea.repository;

import com.admin.aerolinea.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAirlineRepository extends JpaRepository<Airline, String> {


}

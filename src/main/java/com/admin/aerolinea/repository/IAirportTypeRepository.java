package com.admin.aerolinea.repository;

import com.admin.aerolinea.entity.AirportType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAirportTypeRepository extends JpaRepository<AirportType, String> {
}

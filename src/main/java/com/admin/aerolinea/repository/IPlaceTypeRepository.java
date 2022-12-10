package com.admin.aerolinea.repository;

import com.admin.aerolinea.entity.PlaceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlaceTypeRepository extends JpaRepository<PlaceType, String> {
}

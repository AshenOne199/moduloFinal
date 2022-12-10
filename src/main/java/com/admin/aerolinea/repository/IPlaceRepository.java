package com.admin.aerolinea.repository;

import com.admin.aerolinea.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPlaceRepository extends JpaRepository<Place, String> {

    @Query(value = "SELECT idPlace FROM Place WHERE pais = ?1")
    List<String> findByPaisFK(String pais);

    @Query(value = "SELECT idPlace FROM Place WHERE pais = ?1 AND ciudad IS NOT NULL")
    List<String> findIdPLaceByPais(String pais);

    @Query(value = "SELECT p FROM Place p WHERE p.idPlace = ?1")
    List<Place> findAllById(String idPlace);

    @Query(value = "SELECT placeName FROM Place WHERE idPlace = ?1")
    List<String> findByPlacesNames(String idPlace);
}

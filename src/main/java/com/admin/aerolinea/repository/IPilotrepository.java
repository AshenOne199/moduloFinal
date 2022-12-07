package com.admin.aerolinea.repository;

import com.admin.aerolinea.entity.Pilot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPilotrepository extends JpaRepository<Pilot, String> {

    @Query(value = "SELECT employeeNumber FROM Pilot WHERE airlineCode=?1")
    List<String> findByArilineCode(String airlineCode);

}

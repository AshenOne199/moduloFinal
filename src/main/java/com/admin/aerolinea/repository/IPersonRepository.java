package com.admin.aerolinea.repository;

import com.admin.aerolinea.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPersonRepository extends JpaRepository<Person, String> {

    @Query(value = "SELECT first_name||' '||last_name FROM Person WHERE idPerson = ?1")
    List<String> findByIdPerson(String idPerson);
}

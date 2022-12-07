package com.admin.aerolinea.repository;

import com.admin.aerolinea.entity.Employee;
import com.admin.aerolinea.entity.EmployeeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, EmployeeId> {
    @Query(value = "SELECT idPersonEmployee FROM Employee WHERE employeeId.employeeNumber = ?1")
    List<String> findByEmployeeNumber(String employeeNumber);
}

package com.admin.aerolinea.services;

import com.admin.aerolinea.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final IEmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public List<String> getIdPerson(String employeeNumber) {
        return employeeRepository.findByEmployeeNumber(employeeNumber);
    }
}

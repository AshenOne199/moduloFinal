package com.admin.aerolinea.services;

import com.admin.aerolinea.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final IPersonRepository personRepository;

    @Autowired
    public PersonService(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public List<String> getNames(String idPerson) {
        return personRepository.findByIdPerson(idPerson);
    }
}

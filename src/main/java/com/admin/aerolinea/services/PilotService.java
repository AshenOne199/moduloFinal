package com.admin.aerolinea.services;

import com.admin.aerolinea.repository.IPilotrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PilotService {

    private final IPilotrepository pilotrepository;

    @Autowired
    public PilotService(IPilotrepository pilotrepository) {
        this.pilotrepository = pilotrepository;
    }


    public List<String> getEmployeeNumber(String airlineCode) {
        return pilotrepository.findByArilineCode(airlineCode);
    }

}

package com.admin.aerolinea.services;

import com.admin.aerolinea.entity.Connection;
import com.admin.aerolinea.repository.IConnectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConnectionService {

    private final IConnectionRepository connectionRepository;

    @Autowired
    public ConnectionService(IConnectionRepository connectionRepository) {
        this.connectionRepository = connectionRepository;
    }

    public Optional<Connection> findById(Long idConexiones) {
        return connectionRepository.findByIds(idConexiones);
    }

    public Connection nuevaConexion(Connection connection) {
        return connectionRepository.save(connection);
    }

    public List<String> findConections(String origenAirlineCode, String origenFlightNumber, String origenAirportCodeDestino, String origenIdSegment) {
        return  connectionRepository.findConnection(origenAirlineCode, origenFlightNumber, origenAirportCodeDestino, origenIdSegment);
    }

    public String findMaxId() {
        return connectionRepository.findMaxId();
    }
}

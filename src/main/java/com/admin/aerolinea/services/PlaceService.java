package com.admin.aerolinea.services;

import com.admin.aerolinea.entity.Place;
import com.admin.aerolinea.repository.IPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {

    private final IPlaceRepository placeRepository;

    @Autowired
    public PlaceService(IPlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }


    public List<String> getIdPlace(String pais) {
        return placeRepository.findByPaisFK(pais);
    }

    public List<String> getIdPlaceByPais(String pais) {
        return placeRepository.findIdPLaceByPais(pais);
    }

    public  List<Place> getById(String idPlace) {
        return placeRepository.findAllById(idPlace);
    }
}

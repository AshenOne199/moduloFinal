package com.admin.aerolinea.services;

import com.admin.aerolinea.entity.PlaceType;
import com.admin.aerolinea.repository.IPlaceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PlaceTypeService {

    private final IPlaceTypeRepository placeTypeRepository;

    @Autowired
    public PlaceTypeService(IPlaceTypeRepository placeTypeRepository) {
        this.placeTypeRepository = placeTypeRepository;
    }

    @Transactional
    public PlaceType nuevoPlaceType(PlaceType placeType){
        return placeTypeRepository.save(placeType);
    }

    public Optional<PlaceType> findById(PlaceType placeType){
        return placeTypeRepository.findById(placeType.getIdPlaceType());
    }

}

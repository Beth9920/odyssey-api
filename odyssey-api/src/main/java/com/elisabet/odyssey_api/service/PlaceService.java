package com.elisabet.odyssey_api.service;

import com.elisabet.odyssey_api.entity.Place;
import com.elisabet.odyssey_api.exception.PlaceAlreadyExistsException;
import com.elisabet.odyssey_api.repository.PlaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {

    private final PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public List<Place> getAllPlaces() {
        return placeRepository.findAll();
    }

    public Place createPlace(Place place) {

        if (placeRepository.findByName(place.getName()).isPresent()) {
            throw new PlaceAlreadyExistsException(place.getName());
        }

        return placeRepository.save(place);
    }

    public Place getPlaceById(Long id) {
        return placeRepository.findById(id).orElse(null);
    }

    public Place updatePlace(Long id, Place updatedPlace) {

        Place place = placeRepository.findById(id).orElse(null);

        if (place == null) {
            return null;
        }

        place.setName(updatedPlace.getName());
        place.setLocation(updatedPlace.getLocation());
        place.setDescription(updatedPlace.getDescription());

        return placeRepository.save(place);
    }

    public void deletePlace(Long id) {
        placeRepository.deleteById(id);
    }

    public Place getPlaceByName(String name) {
        return placeRepository.findByName(name).orElse(null);
    }

}
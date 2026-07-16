package com.elisabet.odyssey_api.service;

import com.elisabet.odyssey_api.dto.PlaceResponse;
import com.elisabet.odyssey_api.entity.Place;
import com.elisabet.odyssey_api.entity.Rhapsody;
import com.elisabet.odyssey_api.exception.PlaceAlreadyExistsException;
import com.elisabet.odyssey_api.mapper.PlaceMapper;
import com.elisabet.odyssey_api.repository.PlaceRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaceService {

    private final PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public List<PlaceResponse> getAllPlaces() {

        return placeRepository.findAll()
                .stream()
                .map(PlaceMapper::toResponse)
                .collect(Collectors.toList());
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

    public Place getPlaceByName(String name) {
        return placeRepository.findByName(name).orElse(null);
    }

    public PlaceResponse getPlaceResponseById(Long id) {

        Place place = placeRepository.findById(id).orElse(null);

        if (place == null) {
            return null;
        }

        return PlaceMapper.toResponse(place);
    }

    public PlaceResponse getPlaceResponseByName(String name) {

        Place place = placeRepository.findByName(name).orElse(null);

        if (place == null) {
            return null;
        }

        return PlaceMapper.toResponse(place);
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

    @Transactional
    public void deletePlace(String name) {

        Place place = placeRepository.findByName(name).orElse(null);

        if (place == null) {
            return;
        }

        for (Rhapsody rhapsody : place.getRhapsodies()) {
            rhapsody.getPlaces().remove(place);
        }

        placeRepository.delete(place);
    }
}
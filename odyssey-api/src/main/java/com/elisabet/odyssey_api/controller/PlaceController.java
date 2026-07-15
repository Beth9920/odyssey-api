package com.elisabet.odyssey_api.controller;

import com.elisabet.odyssey_api.dto.PlaceResponse;
import com.elisabet.odyssey_api.entity.Place;
import com.elisabet.odyssey_api.service.PlaceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/places")
public class PlaceController {

    private final PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @PostMapping
    public Place createPlace(@RequestBody Place place) {
        return placeService.createPlace(place);
    }

    @GetMapping
    public List<PlaceResponse> getAllPlaces() {
        return placeService.getAllPlaces();
    }

    @GetMapping("/{id}")
    public PlaceResponse getPlaceById(@PathVariable Long id) {
        return placeService.getPlaceResponseById(id);
    }

    @PutMapping("/{id}")
    public Place updatePlace(@PathVariable Long id,
                             @RequestBody Place place) {
        return placeService.updatePlace(id, place);
    }

    @DeleteMapping("/{id}")
    public void deletePlace(@PathVariable Long id) {
        placeService.deletePlace(id);
    }

    @GetMapping("/search")
    public PlaceResponse getPlaceByName(@RequestParam String name) {
        return placeService.getPlaceResponseByName(name);
    }
}
package com.elisabet.odyssey_api.mapper;

import com.elisabet.odyssey_api.dto.PlaceResponse;
import com.elisabet.odyssey_api.dto.PlaceSummary;
import com.elisabet.odyssey_api.dto.RhapsodySummary;
import com.elisabet.odyssey_api.entity.Place;

import java.util.List;
import java.util.stream.Collectors;

public class PlaceMapper {

    public static PlaceSummary toSummary(Place place) {

        return new PlaceSummary(
                place.getId(),
                place.getName()
        );
    }

    public static PlaceResponse toResponse(Place place) {

        List<RhapsodySummary> rhapsodies = place.getRhapsodies()
                .stream()
                .map(r -> new RhapsodySummary(
                        r.getId(),
                        r.getNumber(),
                        r.getTitle()
                ))
                .collect(Collectors.toList());

        return new PlaceResponse(
                place.getId(),
                place.getName(),
                place.getLocation(),
                place.getDescription(),
                rhapsodies
        );
    }
}
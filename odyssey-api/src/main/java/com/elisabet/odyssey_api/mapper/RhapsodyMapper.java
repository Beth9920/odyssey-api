package com.elisabet.odyssey_api.mapper;

import com.elisabet.odyssey_api.dto.ArtifactSummary;
import com.elisabet.odyssey_api.dto.CharacterSummary;
import com.elisabet.odyssey_api.dto.PlaceSummary;
import com.elisabet.odyssey_api.dto.RhapsodyResponse;
import com.elisabet.odyssey_api.entity.Rhapsody;

import java.util.List;
import java.util.stream.Collectors;

public class RhapsodyMapper {

    public static RhapsodyResponse toResponse(Rhapsody rhapsody) {

        List<CharacterSummary> characters = rhapsody.getCharacters()
                .stream()
                .map(CharacterMapper::toSummary)
                .collect(Collectors.toList());

        List<PlaceSummary> places = rhapsody.getPlaces()
                .stream()
                .map(PlaceMapper::toSummary)
                .collect(Collectors.toList());

        List<ArtifactSummary> artifacts = rhapsody.getArtifacts()
                .stream()
                .map(ArtifactMapper::toSummary)
                .collect(Collectors.toList());

        return new RhapsodyResponse(
                rhapsody.getId(),
                rhapsody.getNumber(),
                rhapsody.getTitle(),
                rhapsody.getSummary(),
                characters,
                places,
                artifacts
        );
    }
}
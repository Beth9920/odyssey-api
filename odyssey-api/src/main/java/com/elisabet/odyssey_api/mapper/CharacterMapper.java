package com.elisabet.odyssey_api.mapper;

import com.elisabet.odyssey_api.dto.CharacterResponse;
import com.elisabet.odyssey_api.dto.CharacterSummary;
import com.elisabet.odyssey_api.dto.RhapsodySummary;
import com.elisabet.odyssey_api.entity.Character;
import com.elisabet.odyssey_api.entity.Rhapsody;

import java.util.List;
import java.util.stream.Collectors;

public class CharacterMapper {

    public static CharacterSummary toSummary(Character character) {

        return new CharacterSummary(
                character.getId(),
                character.getName()
        );
    }

    public static CharacterResponse toResponse(Character character) {

        List<RhapsodySummary> rhapsodies = character.getRhapsodies()
                .stream()
                .map(rhapsody -> new RhapsodySummary(
                        rhapsody.getId(),
                        rhapsody.getNumber(),
                        rhapsody.getTitle()
                ))
                .collect(Collectors.toList());

        return new CharacterResponse(
                character.getId(),
                character.getName(),
                character.getType(),
                character.getTitle(),
                character.getDescription(),
                rhapsodies
        );
    }
}
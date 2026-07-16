package com.elisabet.odyssey_api.service;

import com.elisabet.odyssey_api.dto.RhapsodyResponse;
import com.elisabet.odyssey_api.entity.Artifact;
import com.elisabet.odyssey_api.entity.Character;
import com.elisabet.odyssey_api.entity.Place;
import com.elisabet.odyssey_api.entity.Rhapsody;
import com.elisabet.odyssey_api.exception.RhapsodyAlreadyExistsException;
import com.elisabet.odyssey_api.mapper.RhapsodyMapper;
import com.elisabet.odyssey_api.repository.ArtifactRepository;
import com.elisabet.odyssey_api.repository.CharacterRepository;
import com.elisabet.odyssey_api.repository.PlaceRepository;
import com.elisabet.odyssey_api.repository.RhapsodyRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RhapsodyService {

    private final RhapsodyRepository rhapsodyRepository;
    private final CharacterRepository characterRepository;
    private final PlaceRepository placeRepository;
    private final ArtifactRepository artifactRepository;

    public RhapsodyService(RhapsodyRepository rhapsodyRepository,
                           CharacterRepository characterRepository,
                           PlaceRepository placeRepository,
                           ArtifactRepository artifactRepository) {
        this.rhapsodyRepository = rhapsodyRepository;
        this.characterRepository = characterRepository;
        this.placeRepository = placeRepository;
        this.artifactRepository = artifactRepository;
    }

    public List<RhapsodyResponse> getAllRhapsodies() {

        return rhapsodyRepository.findAll()
                .stream()
                .map(RhapsodyMapper::toResponse)
                .collect(Collectors.toList());
    }

    public Rhapsody createRhapsody(Rhapsody rhapsody) {

        if (rhapsodyRepository.findByNumber(rhapsody.getNumber()).isPresent()) {
            throw new RhapsodyAlreadyExistsException(rhapsody.getNumber());
        }

        return rhapsodyRepository.save(rhapsody);
    }

    public Rhapsody getRhapsodyById(Long id) {
        return rhapsodyRepository.findById(id).orElse(null);
    }

    public Rhapsody getRhapsodyByNumber(Integer number) {
        return rhapsodyRepository.findByNumber(number).orElse(null);
    }

    public RhapsodyResponse getRhapsodyResponseByNumber(Integer number) {

        Rhapsody rhapsody = rhapsodyRepository.findByNumber(number).orElse(null);

        if (rhapsody == null) {
            return null;
        }

        return RhapsodyMapper.toResponse(rhapsody);
    }

    public Rhapsody updateRhapsody(Integer number, Rhapsody updatedRhapsody) {

        Rhapsody rhapsody = rhapsodyRepository.findByNumber(number).orElse(null);

        if (rhapsody == null) {
            return null;
        }

        rhapsody.setNumber(updatedRhapsody.getNumber());
        rhapsody.setTitle(updatedRhapsody.getTitle());
        rhapsody.setSummary(updatedRhapsody.getSummary());

        return rhapsodyRepository.save(rhapsody);
    }

    @Transactional
    public void deleteRhapsody(Integer number) {

        Rhapsody rhapsody = rhapsodyRepository.findByNumber(number).orElse(null);

        if (rhapsody == null) {
            return;
        }

        for (Character character : rhapsody.getCharacters()) {
            character.getRhapsodies().remove(rhapsody);
        }

        for (Place place : rhapsody.getPlaces()) {
            place.getRhapsodies().remove(rhapsody);
        }

        for (Artifact artifact : rhapsody.getArtifacts()) {
            artifact.getRhapsodies().remove(rhapsody);
        }

        rhapsodyRepository.delete(rhapsody);
    }

    public Rhapsody addCharacterToRhapsody(Integer number, String name) {

        Rhapsody rhapsody = rhapsodyRepository.findByNumber(number).orElse(null);
        Character character = characterRepository.findByName(name).orElse(null);

        if (rhapsody == null || character == null) {
            return null;
        }

        rhapsody.getCharacters().add(character);

        return rhapsodyRepository.save(rhapsody);
    }

    public Rhapsody addPlaceToRhapsody(Integer number, String name) {

        Rhapsody rhapsody = rhapsodyRepository.findByNumber(number).orElse(null);
        Place place = placeRepository.findByName(name).orElse(null);

        if (rhapsody == null || place == null) {
            return null;
        }

        rhapsody.getPlaces().add(place);

        return rhapsodyRepository.save(rhapsody);
    }

    public Rhapsody addArtifactToRhapsody(Integer number, String name) {

        Rhapsody rhapsody = rhapsodyRepository.findByNumber(number).orElse(null);
        Artifact artifact = artifactRepository.findByName(name).orElse(null);

        if (rhapsody == null || artifact == null) {
            return null;
        }

        rhapsody.getArtifacts().add(artifact);

        return rhapsodyRepository.save(rhapsody);
    }
}
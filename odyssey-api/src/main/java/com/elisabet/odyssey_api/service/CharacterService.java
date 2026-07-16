package com.elisabet.odyssey_api.service;

import com.elisabet.odyssey_api.dto.CharacterResponse;
import com.elisabet.odyssey_api.entity.Artifact;
import com.elisabet.odyssey_api.entity.Character;
import com.elisabet.odyssey_api.entity.Rhapsody;
import com.elisabet.odyssey_api.exception.CharacterAlreadyExistsException;
import com.elisabet.odyssey_api.mapper.CharacterMapper;
import com.elisabet.odyssey_api.repository.ArtifactRepository;
import com.elisabet.odyssey_api.repository.CharacterRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;
    private final ArtifactRepository artifactRepository;

    public CharacterService(CharacterRepository characterRepository,
                            ArtifactRepository artifactRepository) {
        this.characterRepository = characterRepository;
        this.artifactRepository = artifactRepository;
    }

    public List<CharacterResponse> getAllCharacters() {

        return characterRepository.findAll()
                .stream()
                .map(CharacterMapper::toResponse)
                .collect(Collectors.toList());
    }

    public Character createCharacter(Character character) {

        if (characterRepository.findByName(character.getName()).isPresent()) {
            throw new CharacterAlreadyExistsException(character.getName());
        }

        return characterRepository.save(character);
    }

    public Character getCharacterById(Long id) {
        return characterRepository.findById(id).orElse(null);
    }

    public Character getCharacterByName(String name) {
        return characterRepository.findByName(name).orElse(null);
    }

    public CharacterResponse getCharacterResponseById(Long id) {

        Character character = characterRepository.findById(id).orElse(null);

        if (character == null) {
            return null;
        }

        return CharacterMapper.toResponse(character);
    }

    public CharacterResponse getCharacterResponseByName(String name) {

        Character character = characterRepository.findByName(name).orElse(null);

        if (character == null) {
            return null;
        }

        return CharacterMapper.toResponse(character);
    }

    public Character updateCharacter(Long id, Character updatedCharacter) {

        Character character = characterRepository.findById(id).orElse(null);

        if (character == null) {
            return null;
        }

        character.setName(updatedCharacter.getName());
        character.setType(updatedCharacter.getType());
        character.setTitle(updatedCharacter.getTitle());
        character.setDescription(updatedCharacter.getDescription());

        return characterRepository.save(character);
    }

    @Transactional
    public void deleteCharacter(String name) {

        Character character = characterRepository.findByName(name).orElse(null);

        if (character == null) {
            return;
        }

        for (Rhapsody rhapsody : character.getRhapsodies()) {
            rhapsody.getCharacters().remove(character);
        }

        for (Artifact artifact : character.getArtifacts()) {
            artifact.getOwners().remove(character);
        }

        characterRepository.delete(character);
    }

    public Character addArtifactToCharacter(String characterName, String artifactName) {

        Character character = characterRepository.findByName(characterName).orElse(null);
        Artifact artifact = artifactRepository.findByName(artifactName).orElse(null);

        if (character == null || artifact == null) {
            return null;
        }

        character.getArtifacts().add(artifact);

        return characterRepository.save(character);
    }
}
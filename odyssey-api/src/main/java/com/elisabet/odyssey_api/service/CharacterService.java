package com.elisabet.odyssey_api.service;

import com.elisabet.odyssey_api.exception.CharacterAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.elisabet.odyssey_api.repository.CharacterRepository;
import com.elisabet.odyssey_api.entity.Character;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CharacterService {
    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
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

    public void deleteCharacter(Long id) {
        characterRepository.deleteById(id);
    }

    public Character getCharacterByName(String name) {
        return characterRepository.findByName(name).orElse(null);
    }

}

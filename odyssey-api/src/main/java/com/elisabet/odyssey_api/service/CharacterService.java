package com.elisabet.odyssey_api.service;

import org.springframework.stereotype.Service;
import com.elisabet.odyssey_api.repository.CharacterRepository;
import com.elisabet.odyssey_api.entity.Character;
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

}

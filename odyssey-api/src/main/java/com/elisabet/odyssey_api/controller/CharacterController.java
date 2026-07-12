package com.elisabet.odyssey_api.controller;

import com.elisabet.odyssey_api.entity.Character;
import com.elisabet.odyssey_api.service.CharacterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {
    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public List<Character> getAllCharacters() {
        return characterService.getAllCharacters();
    }
}
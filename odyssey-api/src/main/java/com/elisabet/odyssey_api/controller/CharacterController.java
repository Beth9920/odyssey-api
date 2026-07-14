package com.elisabet.odyssey_api.controller;

import com.elisabet.odyssey_api.entity.Character;
import com.elisabet.odyssey_api.service.CharacterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @PostMapping
    public Character createCharacter(@RequestBody Character character) {
        return characterService.createCharacter(character);
    }

    @GetMapping
    public List<Character> getAllCharacters() {
        return characterService.getAllCharacters();
    }

    @GetMapping("/{id}")
    public Character getCharacterById(@PathVariable Long id) {
        return characterService.getCharacterById(id);
    }

    @PutMapping("/{id}")
    public Character updateCharacter(@PathVariable Long id,
                                     @RequestBody Character character) {
        return characterService.updateCharacter(id, character);
    }

    @DeleteMapping("/{id}")
    public void deleteCharacter(@PathVariable Long id) {
        characterService.deleteCharacter(id);
    }

    @GetMapping("/search")
    public Character getCharacterByName(@RequestParam String name) {
        return characterService.getCharacterByName(name);
    }

}
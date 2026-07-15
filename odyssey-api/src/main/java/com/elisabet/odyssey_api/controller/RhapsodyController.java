package com.elisabet.odyssey_api.controller;

import com.elisabet.odyssey_api.dto.RhapsodyResponse;
import com.elisabet.odyssey_api.entity.Rhapsody;
import com.elisabet.odyssey_api.service.RhapsodyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rhapsodies")
public class RhapsodyController {

    private final RhapsodyService rhapsodyService;

    public RhapsodyController(RhapsodyService rhapsodyService) {
        this.rhapsodyService = rhapsodyService;
    }

    @PostMapping
    public Rhapsody createRhapsody(@RequestBody Rhapsody rhapsody) {
        return rhapsodyService.createRhapsody(rhapsody);
    }

    @GetMapping
    public List<RhapsodyResponse> getAllRhapsodies() {
        return rhapsodyService.getAllRhapsodies();
    }

    @GetMapping("/{number}")
    public RhapsodyResponse getRhapsodyByNumber(@PathVariable Integer number) {
        return rhapsodyService.getRhapsodyResponseByNumber(number);
    }

    @GetMapping("/id/{id}")
    public Rhapsody getRhapsodyById(@PathVariable Long id) {
        return rhapsodyService.getRhapsodyById(id);
    }

    @PutMapping("/{number}")
    public Rhapsody updateRhapsody(@PathVariable Integer number,
                                   @RequestBody Rhapsody rhapsody) {
        return rhapsodyService.updateRhapsody(number, rhapsody);
    }

    @DeleteMapping("/{number}")
    public void deleteRhapsody(@PathVariable Integer number) {
        rhapsodyService.deleteRhapsody(number);
    }

    @PostMapping("/{number}/characters/{name}")
    public RhapsodyResponse addCharacterToRhapsody(@PathVariable Integer number,
                                                   @PathVariable String name) {
        rhapsodyService.addCharacterToRhapsody(number, name);
        return rhapsodyService.getRhapsodyResponseByNumber(number);
    }

    @PostMapping("/{number}/places/{name}")
    public RhapsodyResponse addPlaceToRhapsody(@PathVariable Integer number,
                                               @PathVariable String name) {
        rhapsodyService.addPlaceToRhapsody(number, name);
        return rhapsodyService.getRhapsodyResponseByNumber(number);
    }
}
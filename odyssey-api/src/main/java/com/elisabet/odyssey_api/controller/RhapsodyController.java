package com.elisabet.odyssey_api.controller;

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
    public List<Rhapsody> getAllRhapsodies() {
        return rhapsodyService.getAllRhapsodies();
    }

    @GetMapping("/{id}")
    public Rhapsody getRhapsodyById(@PathVariable Long id) {
        return rhapsodyService.getRhapsodyById(id);
    }

    @PutMapping("/{id}")
    public Rhapsody updateRhapsody(@PathVariable Long id,
                                   @RequestBody Rhapsody rhapsody) {
        return rhapsodyService.updateRhapsody(id, rhapsody);
    }

    @DeleteMapping("/{id}")
    public void deleteRhapsody(@PathVariable Long id) {
        rhapsodyService.deleteRhapsody(id);
    }
}
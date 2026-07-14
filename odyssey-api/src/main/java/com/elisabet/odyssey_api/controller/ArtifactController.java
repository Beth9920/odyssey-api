package com.elisabet.odyssey_api.controller;

import com.elisabet.odyssey_api.entity.Artifact;
import com.elisabet.odyssey_api.service.ArtifactService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artifacts")
public class ArtifactController {

    private final ArtifactService artifactService;

    public ArtifactController(ArtifactService artifactService) {
        this.artifactService = artifactService;
    }

    @PostMapping
    public Artifact createArtifact(@RequestBody Artifact artifact) {
        return artifactService.createArtifact(artifact);
    }

    @GetMapping
    public List<Artifact> getAllArtifacts() {
        return artifactService.getAllArtifacts();
    }

    @GetMapping("/{id}")
    public Artifact getArtifactById(@PathVariable Long id) {
        return artifactService.getArtifactById(id);
    }

    @PutMapping("/{id}")
    public Artifact updateArtifact(@PathVariable Long id,
                                   @RequestBody Artifact artifact) {
        return artifactService.updateArtifact(id, artifact);
    }

    @DeleteMapping("/{id}")
    public void deleteArtifact(@PathVariable Long id) {
        artifactService.deleteArtifact(id);
    }
}
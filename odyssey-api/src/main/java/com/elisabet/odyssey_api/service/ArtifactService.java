package com.elisabet.odyssey_api.service;

import com.elisabet.odyssey_api.entity.Artifact;
import com.elisabet.odyssey_api.entity.Character;
import com.elisabet.odyssey_api.repository.ArtifactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtifactService {

    private final ArtifactRepository artifactRepository;

    public ArtifactService(ArtifactRepository artifactRepository) {
        this.artifactRepository = artifactRepository;
    }

    public List<Artifact> getAllArtifacts() {
        return artifactRepository.findAll();
    }

    public Artifact createArtifact(Artifact artifact) {
        return artifactRepository.save(artifact);
    }

    public Artifact getArtifactById(Long id) {
        return artifactRepository.findById(id).orElse(null);
    }

    public Artifact updateArtifact(Long id, Artifact updatedArtifact) {

        Artifact artifact = artifactRepository.findById(id).orElse(null);

        if (artifact == null) {
            return null;
        }

        artifact.setName(updatedArtifact.getName());
        artifact.setDescription(updatedArtifact.getDescription());

        return artifactRepository.save(artifact);
    }

    public void deleteArtifact(Long id) {
        artifactRepository.deleteById(id);
    }

    public Artifact getArtifactByName(String name) {
        return artifactRepository.findByName(name).orElse(null);
    }

}
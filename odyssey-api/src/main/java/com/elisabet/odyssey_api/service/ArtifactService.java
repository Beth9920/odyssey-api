package com.elisabet.odyssey_api.service;

import com.elisabet.odyssey_api.dto.ArtifactResponse;
import com.elisabet.odyssey_api.entity.Artifact;
import com.elisabet.odyssey_api.exception.ArtifactAlreadyExistsException;
import com.elisabet.odyssey_api.mapper.ArtifactMapper;
import com.elisabet.odyssey_api.repository.ArtifactRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtifactService {

    private final ArtifactRepository artifactRepository;

    public ArtifactService(ArtifactRepository artifactRepository) {
        this.artifactRepository = artifactRepository;
    }

    public List<ArtifactResponse> getAllArtifacts() {

        return artifactRepository.findAll()
                .stream()
                .map(ArtifactMapper::toResponse)
                .collect(Collectors.toList());
    }

    public Artifact createArtifact(Artifact artifact) {

        if (artifactRepository.findByName(artifact.getName()).isPresent()) {
            throw new ArtifactAlreadyExistsException(artifact.getName());
        }

        return artifactRepository.save(artifact);
    }

    public Artifact getArtifactById(Long id) {
        return artifactRepository.findById(id).orElse(null);
    }

    public Artifact getArtifactByName(String name) {
        return artifactRepository.findByName(name).orElse(null);
    }

    public ArtifactResponse getArtifactResponseById(Long id) {

        Artifact artifact = artifactRepository.findById(id).orElse(null);

        if (artifact == null) {
            return null;
        }

        return ArtifactMapper.toResponse(artifact);
    }

    public ArtifactResponse getArtifactResponseByName(String name) {

        Artifact artifact = artifactRepository.findByName(name).orElse(null);

        if (artifact == null) {
            return null;
        }

        return ArtifactMapper.toResponse(artifact);
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
}
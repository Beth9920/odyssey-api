package com.elisabet.odyssey_api.repository;

import com.elisabet.odyssey_api.entity.Artifact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtifactRepository extends JpaRepository<Artifact, Long> {
    Optional<Artifact> findByName(String name);
}
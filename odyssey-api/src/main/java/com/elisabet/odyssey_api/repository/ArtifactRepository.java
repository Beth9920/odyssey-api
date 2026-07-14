package com.elisabet.odyssey_api.repository;

import com.elisabet.odyssey_api.entity.Artifact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtifactRepository extends JpaRepository<Artifact, Long> {
}
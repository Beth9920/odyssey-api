package com.elisabet.odyssey_api.mapper;

import com.elisabet.odyssey_api.dto.ArtifactResponse;
import com.elisabet.odyssey_api.dto.ArtifactSummary;
import com.elisabet.odyssey_api.dto.RhapsodySummary;
import com.elisabet.odyssey_api.entity.Artifact;

import java.util.List;
import java.util.stream.Collectors;

public class ArtifactMapper {

    public static ArtifactSummary toSummary(Artifact artifact) {

        return new ArtifactSummary(
                artifact.getId(),
                artifact.getName()
        );
    }

    public static ArtifactResponse toResponse(Artifact artifact) {

        List<RhapsodySummary> rhapsodies = artifact.getRhapsodies()
                .stream()
                .map(r -> new RhapsodySummary(
                        r.getId(),
                        r.getNumber(),
                        r.getTitle()
                ))
                .collect(Collectors.toList());

        return new ArtifactResponse(
                artifact.getId(),
                artifact.getName(),
                artifact.getDescription(),
                rhapsodies
        );
    }
}
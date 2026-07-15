package com.elisabet.odyssey_api.dto;

import java.util.List;

public class ArtifactResponse {

    private Long id;
    private String name;
    private String description;
    private List<RhapsodySummary> rhapsodies;
    private List<CharacterSummary> owners;

    public ArtifactResponse(Long id,
                            String name,
                            String description,
                            List<RhapsodySummary> rhapsodies,
                            List<CharacterSummary> owners) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.rhapsodies = rhapsodies;
        this.owners = owners;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<RhapsodySummary> getRhapsodies() {
        return rhapsodies;
    }

    public List<CharacterSummary> getOwners() {
        return owners;
    }
}
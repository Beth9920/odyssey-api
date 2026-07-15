package com.elisabet.odyssey_api.dto;

import com.elisabet.odyssey_api.entity.CharacterType;

import java.util.List;

public class CharacterResponse {

    private Long id;
    private String name;
    private CharacterType type;
    private String title;
    private String description;
    private List<RhapsodySummary> rhapsodies;
    private List<ArtifactSummary> artifacts;

    public CharacterResponse(Long id,
                             String name,
                             CharacterType type,
                             String title,
                             String description,
                             List<RhapsodySummary> rhapsodies,
                             List<ArtifactSummary> artifacts) {

        this.id = id;
        this.name = name;
        this.type = type;
        this.title = title;
        this.description = description;
        this.rhapsodies = rhapsodies;
        this.artifacts = artifacts;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CharacterType getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<RhapsodySummary> getRhapsodies() {
        return rhapsodies;
    }

    public List<ArtifactSummary> getArtifacts() {
        return artifacts;
    }
}
package com.elisabet.odyssey_api.dto;

public class ArtifactSummary {

    private Long id;
    private String name;

    public ArtifactSummary(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
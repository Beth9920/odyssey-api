package com.elisabet.odyssey_api.dto;

public class CharacterSummary {
    private Long id;
    private String name;

    public CharacterSummary(Long id, String name) {
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

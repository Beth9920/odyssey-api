package com.elisabet.odyssey_api.dto;

import java.util.List;

public class RhapsodyResponse {

    private Long id;
    private Integer number;
    private String title;
    private String summary;
    private List<CharacterSummary> characters;
    private List<PlaceSummary> places;

    public RhapsodyResponse(Long id,
                            Integer number,
                            String title,
                            String summary,
                            List<CharacterSummary> characters,
                            List<PlaceSummary> places) {
        this.id = id;
        this.number = number;
        this.title = title;
        this.summary = summary;
        this.characters = characters;
        this.places = places;
    }

    public Long getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public List<CharacterSummary> getCharacters() {
        return characters;
    }

    public List<PlaceSummary> getPlaces() {
        return places;
    }
}
package com.elisabet.odyssey_api.dto;

import java.util.List;

public class PlaceResponse {

    private Long id;
    private String name;
    private String location;
    private String description;
    private List<RhapsodySummary> rhapsodies;

    public PlaceResponse(Long id,
                         String name,
                         String location,
                         String description,
                         List<RhapsodySummary> rhapsodies) {

        this.id = id;
        this.name = name;
        this.location = location;
        this.description = description;
        this.rhapsodies = rhapsodies;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public List<RhapsodySummary> getRhapsodies() {
        return rhapsodies;
    }
}
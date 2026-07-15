package com.elisabet.odyssey_api.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String location;

    private String description;

    @ManyToMany(mappedBy = "places")
    private Set<Rhapsody> rhapsodies = new HashSet<>();

    public Place() {
    }

    public Place(String name, String location, String description) {
        this.name = name;
        this.location = location;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Rhapsody> getRhapsodies() {
        return rhapsodies;
    }

    public void setRhapsodies(Set<Rhapsody> rhapsodies) {
        this.rhapsodies = rhapsodies;
    }
}
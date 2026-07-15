package com.elisabet.odyssey_api.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Artifact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @ManyToMany(mappedBy = "artifacts")
    private Set<Rhapsody> rhapsodies = new HashSet<>();

    @ManyToMany(mappedBy = "artifacts")
    private Set<Character> owners = new HashSet<>();

    public Artifact() {
    }

    public Artifact(Long id, String description, String name) {
        this.id = id;
        this.description = description;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<Character> getOwners() {
        return owners;
    }

    public void setOwners(Set<Character> owners) {
        this.owners = owners;
    }
}
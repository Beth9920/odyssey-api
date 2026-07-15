package com.elisabet.odyssey_api.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private CharacterType type;

    private String title;

    private String description;

    @ManyToMany(mappedBy = "characters")
    private Set<Rhapsody> rhapsodies = new HashSet<>();

    public Character() {
    }

    public Character(String name, CharacterType type, String title, String description) {
        this.name = name;
        this.type = type;
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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





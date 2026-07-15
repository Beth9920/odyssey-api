package com.elisabet.odyssey_api.entity;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Rhapsody {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private Integer number;

    private String title;

    private String summary;

    @ManyToMany
    @JoinTable(
            name = "rhapsody_characters",
            joinColumns = @JoinColumn(name = "rhapsody_id"),
            inverseJoinColumns = @JoinColumn(name = "character_id")
    )
    private Set<Character> characters = new HashSet<>();

    public Rhapsody() {
    }

    public Rhapsody(Integer number, String title, String summary) {
        this.number = number;
        this.title = title;
        this.summary = summary;
    }

    public Long getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Set<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<Character> characters) {
        this.characters = characters;
    }
}
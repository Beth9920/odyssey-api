package com.elisabet.odyssey_api.dto;

public class RhapsodySummary {

    private Long id;
    private Integer number;
    private String title;

    public RhapsodySummary(Long id, Integer number, String title) {
        this.id = id;
        this.number = number;
        this.title = title;
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
}
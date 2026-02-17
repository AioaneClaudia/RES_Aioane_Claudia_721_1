package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MissionEvent {
    @JsonProperty("id")
    private int id;
    @JsonProperty("astronautId")
    private int astronautId;
    @JsonProperty("day")
    private int day;
    @JsonProperty("type")
    private MissionEventType type;
    @JsonProperty("basePoints")
    private int basePoints;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAstronautId() {
        return astronautId;
    }

    public void setAstronautId(int astronautId) {
        this.astronautId = astronautId;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public MissionEventType getType() {
        return type;
    }

    public void setType(MissionEventType type) {
        this.type = type;
    }

    public int getBasePoints() {
        return basePoints;
    }

    public void setBasePoints(int basePoints) {
        this.basePoints = basePoints;
    }

    public int computePoints() {
        return switch (type) {
            case EVA -> basePoints + 2 * day ;
            case SYSTEM_FAILURE -> basePoints - 3 - day ;
            case SCIENCE -> basePoints + (day % 4);
            case MEDICAL -> basePoints - 2 * (day % 3);
            case COMMUNICATION -> basePoints + 5;
        };
}}

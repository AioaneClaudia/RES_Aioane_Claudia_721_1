package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Astronaut {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("spacecraft")
    private String spacecraft;
    @JsonProperty("status")
    private String status;
    @JsonProperty("experienceLevel")
    private int experienceLevel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpacecraft() {
        return spacecraft;
    }

    public void setSpacecraft(String spacecraft) {
        this.spacecraft = spacecraft;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(int experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    @Override
    public String toString() {
        return "[#"+id+"]"+" "+name+" | "+spacecraft+" | "+status+" | "+experienceLevel;
    }
}

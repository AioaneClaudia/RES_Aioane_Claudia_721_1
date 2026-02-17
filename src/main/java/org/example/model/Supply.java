package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Supply {
    @JsonProperty("id")
    private int id;
    @JsonProperty("astronautId")
    private int astronautId;
    @JsonProperty("type")
    private String type;
    @JsonProperty("value")
    private int value;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

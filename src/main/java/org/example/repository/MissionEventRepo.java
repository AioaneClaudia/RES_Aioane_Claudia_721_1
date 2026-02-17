package org.example.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.MissionEvent;

import java.io.File;
import java.util.List;

public class MissionEventRepo {
    public List<MissionEvent> load(String file) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return List.of(mapper.readValue(new File(file), MissionEvent[].class));
    }
}


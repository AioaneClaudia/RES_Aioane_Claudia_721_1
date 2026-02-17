package org.example.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Astronaut;

import java.io.File;
import java.util.List;

public class AstronautRepo {
    public List<Astronaut> load(String file) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return List.of(mapper.readValue(new File(file), Astronaut[].class));
    }
}

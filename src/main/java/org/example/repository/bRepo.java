package org.example.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Vehicle;

import java.io.File;
import java.util.List;

public class bRepo {
    public List<Vehicle> load(String file) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return List.of(mapper.readValue(new File(file), Vehicle[].class));
    }
}


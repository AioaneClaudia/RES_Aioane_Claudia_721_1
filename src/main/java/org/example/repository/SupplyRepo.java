package org.example.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Supply;

import java.io.File;
import java.util.List;

public class SupplyRepo {
    public List<Supply> load(String file) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return List.of(mapper.readValue(new File(file), Supply[].class));
    }
}


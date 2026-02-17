package org.example.service;

import org.example.model.Astronaut;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AstronautService {
    public List<Astronaut> filterBySpacecraft(List<Astronaut> astronauts, String spacecraft) {
        return astronauts.stream()
                .filter(t->t.getSpacecraft().equalsIgnoreCase(spacecraft))
                .filter(t->t.getStatus().equalsIgnoreCase("ACTIVE"))
                .collect(Collectors.toList());
    }

    public List<Astronaut> sortByExperience(List<Astronaut> astronauts) {
        return astronauts.stream()
                .sorted(Comparator.comparing(Astronaut::getExperienceLevel).reversed()
                        .thenComparing(Astronaut::getName))
                .toList();
    }
}

package org.example.service;

import org.example.model.MissionEvent;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EventService {
    public Map<Integer, Integer> computeScores(List<MissionEvent> events) {
        return events.stream()
                .collect(Collectors.groupingBy(
                        MissionEvent::getAstronautId,
                        Collectors.summingInt(MissionEvent::computePoints)
                ));
}}

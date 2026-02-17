package org.example.service;

import org.example.model.MissionEvent;
import org.example.model.MissionEventType;

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
    }

//    public int eventsProMission(List<MissionEvent> events) {
//        return events.stream()
//                .count(Collectors.groupingBy(
//                        MissionEvent::getType);
//
}

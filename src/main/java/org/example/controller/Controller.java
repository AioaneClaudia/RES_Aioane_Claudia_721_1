package org.example.controller;

import org.example.model.Astronaut;
import org.example.model.MissionEvent;
import org.example.model.Supply;
import org.example.repository.AstronautRepo;
import org.example.repository.MissionEventRepo;
import org.example.repository.SupplyRepo;
import org.example.service.AstronautService;
import org.example.service.EventService;

import java.io.FileWriter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Controller {
    private final AstronautService astronautService=new AstronautService();
    private final AstronautRepo astronautRepo=new AstronautRepo();
    private final SupplyRepo supplyRepo=new SupplyRepo();
    private final MissionEventRepo missionEventRepo=new MissionEventRepo();
    private final EventService eventService=new EventService();

    public void run() throws Exception{
        List<Astronaut> astronauts=astronautRepo.load("D:\\Claudia\\IdeaProjects\\Nachprufung\\src\\main\\resources\\astronauts.json");
        List<Supply> supplies=supplyRepo.load("D:\\Claudia\\IdeaProjects\\Nachprufung\\src\\main\\resources\\supplies.json");
        List<MissionEvent> missionEvents=missionEventRepo.load("D:\\Claudia\\IdeaProjects\\Nachprufung\\src\\main\\resources\\events.json");

        //1
        System.out.println("anzahl astronauts:"+astronauts.size());
        System.out.println("anzahl supplies:"+supplies.size());
        System.out.println("anzahl missionEvents:"+missionEvents.size());

        astronauts.forEach(System.out::println);

        //2
        System.out.println("2");
        Scanner sc=new Scanner(System.in);
        System.out.print("input spacecraft:");
        String spacecraft=sc.next();
        astronautService.filterBySpacecraft(astronauts, spacecraft)
                .forEach(System.out::println);

        //3
        System.out.println("3");
        astronautService.sortByExperience(astronauts)
                .forEach(System.out::println);

        //4
        System.out.println("4");
        List<Astronaut> sorted = astronautService.sortByExperience(astronauts);
        try (FileWriter fw = new FileWriter("D:\\Claudia\\IdeaProjects\\Nachprufung\\src\\main\\java\\org\\example\\astronauts_sorted.txt")){
            for (Astronaut  a:sorted){
                fw.write(a.toString()+"\n");
            }
        }

        //5
        System.out.println("5");
        missionEvents.stream().limit(5).forEach(e->System.out.println("Event"+"<"+e.getId()+"> -> "+
                "raw= "+e.getBasePoints()+" -> "+"computed= "+e.computePoints()));

        // 6 Ranking
        System.out.println("6");
        Map<Integer, Integer> eventScores = eventService.computeScores(missionEvents);
        Map<Integer, Integer> supplyScores = supplies.stream()
                .collect(Collectors.groupingBy(
                        Supply::getAstronautId,
                        Collectors.summingInt(Supply::getValue)
                ));

        astronauts.stream()
                .map(t -> Map.entry(
                        t.getName(),
                        eventScores.getOrDefault(t.getId(), 0) +
                                supplyScores.getOrDefault(t.getId(), 0)))
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry::getKey))
                .limit(5)
                .forEachOrdered(e ->
                        System.out.println(e.getKey() + " -> " + e.getValue())
                );

        astronauts.stream()
                .max(Comparator.comparingInt(v ->
                        eventScores.getOrDefault(v.getId(), 0) +
                                supplyScores.getOrDefault(v.getId(), 0)
                ))
                .ifPresent(v -> System.out.println(
                        "Spacecraft des Astronauten aud 1. Platz:" +
                                v.getSpacecraft() + " -> " +
                                (eventScores.getOrDefault(v.getId(), 0) +
                                        supplyScores.getOrDefault(v.getId(), 0))
                ));
    }
}

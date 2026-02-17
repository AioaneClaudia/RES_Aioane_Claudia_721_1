package org.example.controller;

import org.example.model.Astronaut;
import org.example.model.MissionEvent;
import org.example.model.Supply;
import org.example.repository.AstronautRepo;
import org.example.repository.MissionEventRepo;
import org.example.repository.SupplyRepo;
import org.example.service.AstronautService;

import java.util.List;
import java.util.Scanner;

public class Controller {
    private final AstronautService astronautService=new AstronautService();
    private final AstronautRepo astronautRepo=new AstronautRepo();
    private final SupplyRepo supplyRepo=new SupplyRepo();
    private final MissionEventRepo missionEventRepo=new MissionEventRepo();

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
    }
}

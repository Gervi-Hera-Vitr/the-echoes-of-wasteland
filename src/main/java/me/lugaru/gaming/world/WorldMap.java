package me.lugaru.gaming.world;

import java.util.ArrayList;
import java.util.List;

public class WorldMap {
    List<String> areas;
    List<String> people;

    public WorldMap() {
        this.areas = new ArrayList<>();
        this.people = new ArrayList<>();
    }

    public void initializeMap() {
        if (areas.contains("home village")) {
            people.add("Village Elder");
            people.add("Terry");
            people.add("Sally");
            people.add("Village Seer");
            people.add("Village Warrior");
        }
    }

    public void addAreaToMap(String area) {
        areas.add(area);
    }
}

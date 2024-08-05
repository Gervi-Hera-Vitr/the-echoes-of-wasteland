package me.lugaru.gaming.world;

import me.lugaru.gaming.actions.Abilities;

import java.util.ArrayList;
import java.util.List;

public class WorldMap {
    public String currentPlace;
    public List<String> areas;
    public List<String> people;
    public List<String> subAreas;
    public List<String> subPeople;
    public WorldMap(List<String> areas, List<String> people, List<String> subAreas, List<String> subPeople, String currentPlace) {
        this.areas = new ArrayList<>();
        this.people = new ArrayList<>();
        this.subAreas = new ArrayList<>();
        this.subPeople = new ArrayList<>();
        this.currentPlace = "";
    }

    public void initializeMap() {
            areas.add("Home Village");
            people.add("Village Elder");
            people.add("Terry");
            people.add("Sally");
            people.add("Village Seer");
            people.add("Village Warrior");
            subAreas.add("village pub");
            subAreas.add("house");
        }






    public void addAreaToMap(String area) {areas.add(area);}
    public void addSubAreaToMap(String subArea) {subAreas.add(subArea);}
    public void addPeopleToMap(String person) {people.add(person);}
    public void addSubPeopleToMap(String subPerson) {subPeople.add(subPerson);}
    public void setCurrentPlace(String currentPlace) {this.currentPlace = currentPlace;}
}

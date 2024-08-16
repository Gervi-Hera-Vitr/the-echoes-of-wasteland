package me.lugaru.gaming.inventory;
//
public class Leggings extends ArmorPeice {
    double protection;
    public Leggings(String name, int value, double protection, int weight) {
        super(name, "Legging", value, 1, weight);
        this.protection = protection;
    }
}
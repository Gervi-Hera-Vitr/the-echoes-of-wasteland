package me.lugaru.gaming.inventory;

public class Chestplate extends ArmorPeice {
    double protection;
    public Chestplate(String name, int value, double protection, int weight) {
        super(name, "Chestplate", value, 1, weight);
        this.protection = protection;
    }
}
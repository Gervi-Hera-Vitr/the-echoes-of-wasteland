package me.lugaru.gaming.inventory;

public class ArmorPeice extends Item {
    double protection;

    public ArmorPeice(String name, String type, int value, double protection, int weight) {
        super(name, value, 1, weight);
        this.protection = protection;
    }
}
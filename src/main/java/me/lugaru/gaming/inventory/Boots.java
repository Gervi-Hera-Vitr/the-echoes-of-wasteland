package me.lugaru.gaming.inventory;

public class Boots extends ArmorPeice {
    double protection;
    public Boots(String name, int value, double protection, int weight) {
        super(name, "Boot", value, 1, weight);
        this.protection = protection;
    }
}
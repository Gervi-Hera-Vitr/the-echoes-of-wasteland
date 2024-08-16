package me.lugaru.gaming.inventory;
//
public class Helmet extends ArmorPeice {
    double protection;
    public Helmet(String name, int value, double protection, int weight) {
        super(name, "Helmet", value, 1, weight);
        this.protection = protection;
    }
}
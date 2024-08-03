package me.lugaru.gaming.inventory;

public class Armor extends Item {
    int protection;

    public Armor(String name, int value, int protection) {
        super(name, value);
        this.protection = protection;
    }
}

package me.lugaru.gaming.inventory;

public class Armor extends Item {
    int protection;
    int slot;
    public Armor(String name, int value, int protection, int slot) {
        super(name, value);
        this.protection = protection;
        this.slot = slot;
    }

}

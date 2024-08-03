package me.lugaru.gaming.inventory;

public class Weapon extends Item {
    int damage;

    public Weapon(String name, int value, int damage) {
        super(name, value);
        this.damage = damage;
    }
}

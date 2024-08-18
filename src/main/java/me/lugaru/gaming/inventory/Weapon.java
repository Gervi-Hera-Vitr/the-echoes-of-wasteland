package me.lugaru.gaming.inventory;

public class Weapon extends Item {
    int damage;

    public Weapon(String name, int value, int damage, int amount, int weight) {
        super(name, value, amount, weight);
        this.damage = damage;
    }
}

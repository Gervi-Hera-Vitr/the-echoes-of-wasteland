package me.lugaru.gaming.inventory;

public class Item {
    public String name;
    /**
     * Sell value.
     */
    int value;
    int amount;
    double weight;

    public Item(String name, int value, int amount, double weight) {
        this.name = name;
        this.value = value;
        this.amount = amount;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return name + " $" + value;
    }
}

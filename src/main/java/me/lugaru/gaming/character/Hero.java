package me.lugaru.gaming.character;

import me.lugaru.gaming.actions.Abilities;
import me.lugaru.gaming.inventory.Inventory;

public class Hero {
    int maxHunger;
    int maxThirst;
    int hunger;
    int thirst;
    String name;
    int maxHp;
    int exp;
    int hp;
    int damage;
    int shield;
    int stamina;

    public PointSystem pointSystem = new PointSystem(0,0,0,0,0,0,0,21,"Strength", "Perception", "Endurance", "Charisma", "Intelligence", "Agility", "Luck");
    public Inventory inventory = new Inventory();
    public Abilities abilities = new Abilities(this);

    public Hero(String name, int damage, int shield, int stamina, int hp, int maxHp, int exp, int hunger, int thirst, int maxThirst, int maxHunger) {
        this.name = name;
        this.damage = damage * (pointSystem.strength / 2);
        this.shield = shield + pointSystem.endurance;
        this.stamina = stamina + pointSystem.endurance;
        this.hp = hp + pointSystem.endurance;
        this.maxHp = maxHp + pointSystem.endurance;
        this.exp = exp;
        this.thirst = thirst;
        this.hunger = hunger;
        this.maxHunger = maxHunger;
        this.maxThirst = maxThirst;



    }

    public void setName(String name) {
        this.name = name;
    }

    int resetMaxHpMethod() {
        return maxHp;
    }
}

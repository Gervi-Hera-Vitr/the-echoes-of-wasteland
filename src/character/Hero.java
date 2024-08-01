package character;

import actions.Abilities;
import inventory.Armor;
import inventory.Inventory;
import inventory.Item;
import inventory.Weapon;

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

    public PointSystem pointSystem = new PointSystem();
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

        inventory.items.add(new Item("Undies", 1));
        inventory.items.add(new Item("Rock", 1));
        inventory.equipArmor(new Armor("Shit Helmet", 2, 1));
        inventory.equipWeapon(new Weapon("Shit Long-Stick", 1, 2));

    }

    public void setName(String name) {
        this.name = name;
    }

    int resetMaxHpMethod() {
        return maxHp;
    }
}

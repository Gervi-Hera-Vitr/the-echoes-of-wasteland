package me.lugaru.gaming.inventory;
//
import me.lugaru.gaming.character.Hero;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    public List<Item> items;
    public ArmorSet equippedArmor;
    public Weapon equippedWeapon;
    public int total_weight;
    public Hero hero;

    public Inventory() {
        items = new ArrayList<>();
        equippedArmor = new ArmorSet();
    }

    public void addItem(Item acquiredItem) {
        if acquiredItem instanceof
        items.add(acquiredItem);
    }

    public void equipArmor(Armor acquiredArmor) {
        equippedArmor.add(acquiredArmor);
    }

    public void equipWeapon(Weapon aquiredWeapon){
        if (equippedWeapon != null) items.add(equippedWeapon);
        equippedWeapon = aquiredWeapon;
    }


}

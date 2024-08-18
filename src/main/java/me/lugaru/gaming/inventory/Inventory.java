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
       items.add(acquiredItem);
    }

    public void equipArmor(ArmorPeice acquiredArmor) {
        equippedArmor.addArmor(acquiredArmor);
    }

    public void equipWeapon(Weapon aquiredWeapon){
        if (equippedWeapon != null) items.add(equippedWeapon);
        equippedWeapon = aquiredWeapon;
    }


}

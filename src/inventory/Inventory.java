package inventory;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    public List<Item> items;
    public List<Armor> equippedArmor;
    public Weapon equippedWeapon;

    public Inventory() {
        items = new ArrayList<>();
        equippedArmor = new ArrayList<>();
    }

    public void addItem(Item acquiredItem) {
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

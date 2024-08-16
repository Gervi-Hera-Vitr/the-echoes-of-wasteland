package me.lugaru.gaming.inventory;

public class ArmorSet {
    double protection;
    public Helmet head;
    public Chestplate chest;
    public Leggings leg;
    public Boots boots;

    public ArmorSet(Helmet head, Chestplate chest, Leggings leg, Boots boots) {
        this.protection = head.protection + chest.protection + leg.protection + boots.protection;
    }

    public ArmorSet() {
        this.protection = 0;
    }

    public void addArmor(ArmorPeice armor){
        if (armor.type == "Helmet") {

        }
    }
}

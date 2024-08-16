package me.lugaru.gaming.character;

import me.lugaru.gaming.actions.Abilities;
import me.lugaru.gaming.inventory.Inventory;
import me.lugaru.gaming.world.WorldMap;

public class Hero {
  public int maxHunger;
  public  int maxThirst;
  public int hunger;
  public  int thirst;
  public  String name;
  public  int maxHp;
  public int exp;
  public  int hp;
  public  int damage;
  public  int shield;
  public   int stamina;
  public int maxWeight;

    public PointSystem pointSystem = new PointSystem(0,0,0,0,0,0,0,21,"Strength", "Perception", "Endurance", "Charisma", "Intelligence", "Agility", "Luck");
    public Inventory inventory = new Inventory();
    public Abilities abilities = new Abilities(this);
    public WorldMap worldMap = new WorldMap(null,null,null,null, null);
    public Hero(String name, int damage, int shield, int stamina, int hp, int maxHp, int exp, int hunger, int maxHunger, int thirst, int maxThirst, int maxCarry) {
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
        this.maxWeight = maxCarry;
        this.inventory.hero = this;
    }
    public void checkMap(){
        if (worldMap.currentPlace.equals("Home Village")){
            abilities.canCheckInventory = true;
            abilities.canCheckHunger = true;
            abilities.canCheckThirst = true;
            abilities.canTalk = true;
            abilities.canFight = false;
            abilities.canCheckQuest = true;
            abilities.canSteal = false;
            abilities.canBarter = true;
            abilities.canLoot = true;
            abilities.canScrap = false;
            abilities.canMove = true;
            abilities.canHack = false;
            abilities.canCraft = false;
            abilities.canPickLock = true;
            abilities.canWorldMove = true;
            abilities.canCheckWorldMap = true;
            abilities.canCheckAreaMap = true;
        } else if (worldMap.currentPlace.equals("village pub")){
            abilities.canCheckInventory = true;
            abilities.canCheckHunger = true;
            abilities.canCheckThirst = true;
            abilities.canTalk = true;
            abilities.canFight = false;
            abilities.canCheckQuest = true;
            abilities.canSteal = false;
            abilities.canBarter = true;
            abilities.canLoot = false;
            abilities.canScrap = false;
            abilities.canMove = false;
            abilities.canHack = false;
            abilities.canCraft = false;
            abilities.canPickLock = false;
            abilities.canWorldMove = true;
            abilities.canCheckWorldMap = true;
            abilities.canCheckAreaMap = true;
        } else if (worldMap.currentPlace.equals("house")){
            abilities.canCheckInventory = true;
            abilities.canCheckHunger = true;
            abilities.canCheckThirst = true;
            abilities.canTalk = true;
            abilities.canFight = false;
            abilities.canCheckQuest = true;
            abilities.canSteal = false;
            abilities.canBarter = false;
            abilities.canLoot = true;
            abilities.canScrap = false;
            abilities.canMove = false;
            abilities.canHack = false;
            abilities.canCraft = false;
            abilities.canPickLock = false;
            abilities.canWorldMove = true;
            abilities.canCheckWorldMap = true;
            abilities.canCheckAreaMap = true;
        }

    }
    public void setName(String name) {
        this.name = name;

    }

    int resetMaxHpMethod() {
        return maxHp;
    }

}


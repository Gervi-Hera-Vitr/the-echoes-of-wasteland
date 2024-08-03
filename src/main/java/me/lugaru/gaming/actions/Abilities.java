package me.lugaru.gaming.actions;

import me.lugaru.gaming.character.Hero;
import me.lugaru.gaming.inventory.Item;
import me.lugaru.gaming.inventory.Armor;

import java.util.stream.Collectors;

public class Abilities {

    Hero thisHero;

    boolean canCheckInventory = true;
    boolean canCheckHunger = true;
    boolean canCheckThirst = true;
    boolean canTalk = true;
    boolean canFight = true;
    boolean canCheckQuest = true;

    public Abilities(
            Hero myhero) {
        thisHero = myhero;
    }

    public Abilities(boolean canCheckInventory, boolean canCheckHunger, boolean canCheckThirst, boolean canCheckQuest, boolean canTalk, boolean canFight) {
        this.canCheckInventory = canCheckInventory;
        this.canCheckHunger = canCheckHunger;
        this.canCheckThirst = canCheckThirst;
        this.canTalk = canTalk;
        this.canFight = canFight;
        this.canCheckQuest = canCheckQuest;
    }

    public void doAction(String actionMade) {
        System.out.print("What's your action? : ");

        switch (actionMade.trim().toLowerCase()) {
            case "check inventory":
                if (canCheckInventory) {
                    checkInventory();
                }
                break;
            case "check hunger":
                if (canCheckHunger) {
                    checkHunger();
                }
                break;
            case "check thirst":
                if (canCheckThirst) {
                    checkThirst();
                }
                break;
            case "talk":
                if (canTalk) {
                    talk();
                }
                break;
            case "fight":
                if (canFight) {
                    fight();
                }
                break;
            case "check quest":
                if (canCheckQuest) {
                    checkQuest();
                }
                break;
            case "end":
                System.out.println("Ending action.");
                break;
            default:
                System.out.println("Invalid action.");
                break;
        }
    }

    public void showActions() {

        System.out.println("Available Abilities:");
        if (canCheckInventory) {
            System.out.println("Check Inventory");
        }
        if (canCheckHunger) {
            System.out.println("Check Hunger");
        }
        if (canTalk) {
            System.out.println("Talk");
        }
        if (canCheckThirst) {
            System.out.println("Check Thirst");
        }
        if (canCheckQuest) {
            System.out.println("Check Quest");
        }
        if (canFight) {
            System.out.println("Fight");
        }
    }

    public void checkInventory() {
        var myItemsString = thisHero.inventory.items.stream().map(Item::toString).collect(Collectors.joining("\n", "- ", ";"));

        System.out.printf(
                """
                        Hero's Current Inventory:
                           Armor:    %s
                           Weapons:  %s
                        
                           Inventory size: %d
                            %s
                        %n""",
                thisHero.inventory.equippedArmor.stream().map(Armor::toString).collect(Collectors.joining("\n","- ",";")),
                thisHero.inventory.equippedWeapon.toString(),
                thisHero.inventory.items.size(),
                myItemsString);

        //        System.out.println("Inventory: " + Arrays.toString(Inventory.items.toArray()));
    }

    public void checkHunger() {
        System.out.println("Checking Hunger...");
    }

    public void checkThirst() {
        System.out.println("Checking Thirst...");
    }

    public void checkQuest() {
        System.out.println("Checking Quest...");
    }

    public void talk() {
        System.out.println("Talking...");
    }

    public void fight() {
        System.out.println("Fighting...");
    }
}

package me.lugaru.gaming.actions;

import me.lugaru.gaming.character.Hero;
import me.lugaru.gaming.inventory.Item;
import me.lugaru.gaming.inventory.Armor;

import java.util.stream.Collectors;

public class Abilities {

   public Hero thisHero;
   public boolean canCheckWorldMap = true;
   public boolean canCheckInventory = true;
   public boolean canCheckHunger = true;
   public boolean canCheckThirst = true;
    public boolean canTalk = true;
    public boolean canFight = true;
    public boolean canCheckQuest = true;
    public boolean canSteal = true;
    public boolean canBarter = true;
    public boolean canLoot = true;
    public boolean canPickLock = true;
    public boolean canWorldMove = true;
    public boolean canHack = true;
    public boolean canCraft = true;
    public boolean canScrap = true;
    public boolean canMove = true;
    public boolean canCheckAreaMap = true;

    public Abilities(
            Hero myhero) {
        thisHero = myhero;
        // hero
    }

    public Abilities(boolean canCheckInventory, boolean canCheckHunger, boolean canCheckThirst, boolean canCheckQuest, boolean canTalk, boolean canFight, boolean canSteal, boolean canCraft, boolean canPickLock, boolean canWorldMove, boolean canHack, boolean canScrap, boolean canLoot, boolean canBarter, boolean canMove, boolean canCheckAreaMap, boolean canCheckWorldMap) {
        this.canCheckInventory = canCheckInventory;
        this.canCheckHunger = canCheckHunger;
        this.canCheckThirst = canCheckThirst;
        this.canTalk = canTalk;
        this.canFight = canFight;
        this.canCheckQuest = canCheckQuest;
        this.canSteal = canSteal;
        this.canBarter = canBarter;
        this.canLoot = canLoot;
        this.canScrap = canScrap;
        this.canMove = canMove;
        this.canHack = canHack;
        this.canCraft = canCraft;
        this.canPickLock = canPickLock;
        this.canWorldMove = canWorldMove;
        this.canCheckWorldMap = canCheckWorldMap;
        this.canCheckAreaMap = canCheckAreaMap;

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
                case "steal":
                    if (canSteal) {
                       steal();
                    }
                    break;
                    case "barter":
                        if (canBarter) {
                            barter();
                        }
                        break;
                        case "loot":
                            if (canLoot) {
                                looting();
                            }
                            break;
                            case "craft":
                                if (canCraft) {
                                    craft();
                                }
                                break;
                                case "scrap":
                                    if (canScrap) {
                                        scrap();
                                    }
                                    break;
                                    case "move":
                                        if (canMove) {
                                            move();
                                        }
                                        break;
            case "hack":
                if (canHack) {
                    hack();
                }
                break;
                    case "world move":
                        if (canWorldMove) {
                            worldMove();
                        }
                        break;
            case "lock picking":
                if (canPickLock) {
                    lockPicking();
                }
                break;
                case "check world map":
                    if (canWorldMove) {
                        checkWorldMap();
                    }
                    break;
                    case "check area map":
                        if (canCheckAreaMap) {
                            checkAreaMap();
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
        if (canSteal) {
            System.out.println("Steal");
        }
        if (canBarter) {
            System.out.println("Barter");
        }
        if (canLoot) {
            System.out.println("Loot");
        }
        if (canCraft) {
            System.out.println("Craft");
        }
        if (canScrap) {
            System.out.println("Scrap");
        }
        if (canMove) {
            System.out.println("Move");
        }
        if (canWorldMove) {
            System.out.println("World Move");
        }
        if (canHack) {
            System.out.println("Hack");

        }
        if (canPickLock){
            System.out.println("Pick Lock");
        }
        if (canCheckAreaMap) {
            System.out.println("Check Area Map");
        }
        if (canCheckWorldMap) {
            System.out.println("Check World Map");
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
    public void steal(){
        System.out.println("Stealing...");
    }
    public void barter() {
        System.out.println("Bartering...");
    }
    public void craft() {
        System.out.println("Craft...");
    }
    public void scrap() {
        System.out.println("Scraping...");
    }
    public void move() {
        System.out.println("Moving...");
    }
    public void hack() {
        System.out.println("Hacking...");
    }
    public void worldMove(){
        System.out.println("Traveling far");
    }
    public void lockPicking(){
        System.out.println("Locking picking...");
    }
    public void looting(){
        System.out.println("Looting");
    }
    public void checkWorldMap(){
        System.out.println("Checking World Map...");
    }
    public void checkAreaMap(){
        System.out.println("Checking Area Map...");
    }
}


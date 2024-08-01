package actions;

import inventory.Inventory;

import java.util.Arrays;

public class Actions {

    boolean canCheckInventory;
    boolean canCheckHunger;
    boolean canCheckThirst;
    boolean canTalk;
    boolean canFight;
    boolean canCheckQuest;

    public Actions(boolean canCheckInventory, boolean canCheckHunger, boolean canCheckThirst, boolean canCheckQuest, boolean canTalk, boolean canFight) {
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
        System.out.println("Available Actions:");
        System.out.println("Check Inventory");
        System.out.println("Check Hunger");
        System.out.println("Talk");
        System.out.println("Check Thirst");
        System.out.println("Check Quest");
        System.out.println("Fight");
    }

    public void checkInventory() {
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

package me.lugaru.gaming;

import me.lugaru.gaming.actions.Dialogue;
import me.lugaru.gaming.character.Hero;
import me.lugaru.gaming.character.PointSystem;
import me.lugaru.gaming.inventory.Armor;
import me.lugaru.gaming.inventory.Item;
import me.lugaru.gaming.world.WorldMap;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Item bottleCaps = new Item("Bottle caps", 1);
        Armor Leather_Helmet = new Armor("Leather Helmet", 2, 1, 1);

        Scanner scanner = new Scanner(System.in);
        Dialogue dialogue = new Dialogue();
        Hero playerCharacter = new Hero("Soul Survivor", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        dialogue.startGameMethodDialogue();
        dialogue.summaryMethod();
        playerCharacter.pointSystem.gameMethodStart(scanner);
        playerCharacter.worldMap.initializeMap();
        playerCharacter.worldMap.setCurrentPlace("Home Village");
        playerCharacter.inventory.addItem(bottleCaps);
        playerCharacter.inventory.addItem(Leather_Helmet); 
        do {
            playerCharacter.worldMap.initializeMap();
            playerCharacter.abilities.showActions();
            playerCharacter.abilities.doAction(scanner.nextLine());
        } while (playerCharacter.hp < 1);

    }
}
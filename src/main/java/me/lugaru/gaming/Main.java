package me.lugaru.gaming;
import me.lugaru.gaming.actions.Dialogue;
import me.lugaru.gaming.character.Hero;
import me.lugaru.gaming.inventory.ArmorPeice;
import me.lugaru.gaming.inventory.Item;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Item bottleCaps = new Item("Bottle caps", 1, 50, 0.1);
        ArmorPeice Leather_Helmet = new ArmorPeice("Leather Helmet", "Helmet", 1, 1, 1);

        Scanner scanner = new Scanner(System.in);
        Dialogue dialogue = new Dialogue();
        Hero playerCharacter = new Hero("Soul Survivor", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100);
        dialogue.startGameMethodDialogue();
        dialogue.summaryMethod();
        playerCharacter.pointSystem.gameMethodStart(scanner);
        playerCharacter.worldMap.setCurrentPlace("Home Village");
        playerCharacter.inventory.addItem(bottleCaps);
        playerCharacter.inventory.addItem(Leather_Helmet);
        playerCharacter.worldMap.initializeMap();
        do {
            playerCharacter.checkMap();
            playerCharacter.abilities.talk(scanner.nextLine());
        } while (playerCharacter.hp < 1);

    }
}
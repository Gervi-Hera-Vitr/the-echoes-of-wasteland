package me.lugaru.gaming;

import me.lugaru.gaming.actions.Dialogue;
import me.lugaru.gaming.character.Hero;
import me.lugaru.gaming.character.PointSystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Dialogue dialogue = new Dialogue();
        Hero playerCharacter = new Hero("Soul Survivor", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        dialogue.startGameMethodDialogue();
        dialogue.summaryMethod();
        playerCharacter.pointSystem.gameMethodStart(scanner);
    }
}//
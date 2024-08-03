package me.lugaru.gaming;

import me.lugaru.gaming.actions.Dialogue;
import me.lugaru.gaming.character.Hero;

public class Main {

    public static void main(String[] args) {
        Dialogue dialogue = new Dialogue();
        Hero playerCharacter = new Hero("Soul Survivor", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        dialogue.startGameMethodDialogue();
        dialogue.summaryMethod();
    }
}
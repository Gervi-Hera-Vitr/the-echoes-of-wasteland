import actions.Dialogue;
import character.Hero;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Dialogue dialogue = new Dialogue();
        Hero playerCharacter = new Hero("Soul Survivor", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        dialogue.startGameMethodDialogue();
        dialogue.summaryMethod();

    }
}

import character.Hero;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Hero playerCharacter = new Hero("Soul Survivor", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

        Scanner scanner = new Scanner(System.in);

        playerCharacter.abilities.checkInventory();

    }
}

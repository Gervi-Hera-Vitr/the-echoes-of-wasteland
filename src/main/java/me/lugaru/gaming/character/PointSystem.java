package me.lugaru.gaming.character;

import java.util.Scanner;

public class PointSystem {
    int strength;
    int perception;
    int endurance;
    int charisma;
    int intelligence;
    int agility;
    int luck;
    int points;
    String Strength;
    String Perception;
    String Endurance;
    String Charisma;
    String Intelligence;
    String Agility;
    String Luck;



    public PointSystem(int strength, int perception, int endurance, int charisma, int intelligence, int agility, int luck, int points, String Strength, String Perception, String Endurance, String Charisma, String Intelligence, String Agility, String Luck ) {
        strength = strength;
        perception = perception;
        endurance = endurance;
        charisma = charisma;
        intelligence = intelligence;
        agility = agility;
        luck = luck;
        points = points;
        this.Strength = Strength;
        this.Perception = Perception;
        this.Endurance = Endurance;
        this.Charisma = Charisma;
        this.Intelligence = Intelligence;
        this.Agility = Agility;
        this.Luck = Luck;
    }

    public void addPointsMethod() {
        points++;
    }

    public String getAgility() {

        return Agility;
    }

    public String getEndurance() {

        return Endurance;
    }
    public String getIntelligence() {
        return Intelligence;
    }
    public String getStrength() {
        return Strength;
    }
    public String getPerception() {
        return Perception;
    }

    public String getCharisma() {
        return Charisma;
    }
    public String getLuck() {
        return Luck;
    }
    public void changeStatsMethod(Scanner scanner) {
        while (points > 0) {
            System.out.println("Enter a trait to increase, you have " + points + " points (Strength, Perception, Endurance, Charisma, Agility, Luck) or 'end' to stop:");
            String input = scanner.next();

            switch (input.toLowerCase()) {
                case "strength":
                    strength++;
                    points--;
                    break;
                case "perception":
                    perception++;
                    points--;
                    break;
                case "endurance":
                    endurance++;
                    points--;
                    break;
                case "charisma":
                    charisma++;
                    points--;
                    break;
                    case "intelligence":
                        intelligence++;
                        break;
                case "agility":
                    agility++;
                    points--;
                    break;
                case "luck":
                    luck++;
                    points--;
                    break;
                case "end":
                    System.out.println("Exiting the stats allocation method.");
                    return;
                default:
                    System.out.println("Invalid input. Please enter a valid trait or 'end' to stop.");
                    break;
            }

            System.out.println("Points remaining: " + points);
        }

        System.out.println("Final stats - Strength: " + strength + ", Perception: " + perception + ", Endurance: " + endurance + ", Charisma: " + charisma + ", Agility: " + agility + ", Luck: " + luck);
    }

    void gameBeginningMethod(Scanner scanner) {
        while (points > 0) {
            System.out.println("You have " + points + " points remaining.");

            points = allocatePoints(scanner, "Strength", points, strength);
            if (points == 0) break;

            points = allocatePoints(scanner, "Perception", points, perception);
            if (points == 0) break;

            points = allocatePoints(scanner, "Endurance", points, endurance);
            if (points == 0) break;

            points = allocatePoints(scanner, "Charisma", points, charisma);
            if (points == 0) break;

            points = allocatePoints(scanner, "Agility", points, agility);
            if (points == 0) break;

            points = allocatePoints(scanner, "Luck", points, luck);
        }

        System.out.println("Final stats - Strength: " + strength + ", Perception: " + perception + ", Endurance: " + endurance + ", Charisma: " + charisma + ", Agility: " + agility + ", Luck: " + luck);
    }

    private int allocatePoints(Scanner scanner, String trait, int pointsRemaining, int traitValue) {
        System.out.print("Enter points for " + trait + ": ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer value.");
            scanner.next();
        }
        int pointsToAdd = scanner.nextInt();
        if (pointsToAdd > pointsRemaining) {
            System.out.println("You don't have enough points. Try again.");
        } else {
            traitValue += pointsToAdd;
            pointsRemaining -= pointsToAdd;
        }
        return pointsRemaining;
    }
}

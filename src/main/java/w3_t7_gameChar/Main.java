package w3_t7_gameChar;

import java.util.Scanner;

public class Main {
    /*
console-based application that simulates a game character through different levels of proficiency

Guidelines:
    The game character attributes: name, level, experience points, and health points.
    The game character has levels (STATES): novice, intermediate, expert, and master.
    The game character has actions: train, meditate, and fight.

The game levels are as follows:

    Novice level: character only can train. Training increases the character's experience points. A certain amount of XP is required for the next level.

    Intermediate level: In addition to training, character can meditate. Meditating increases the character's health points. A certain amount of XP is required for the next level.

    Expert level: In addition character can fight. Fighting decreases the character's health points but 2x increases XP. A certain amount of experience points is required for the next level.

    Master level: The game ends when the game character reaches the master level.

Before each turn, the game should display the character's current status (including the level) as well as the available actions.

     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your character's name: ");
        String name = scanner.nextLine();

        new Character(name).play();
    }
}

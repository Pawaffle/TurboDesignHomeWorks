package w3_t8_Game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        // Intro printed character-by-character
        typeOut("Welcome to Russian Roulette.", 50);
        typeOut("You choose a number between 1 and 6 — that number is the exact chamber where the bullet is placed.", 50);
        typeOut("The bullet is loaded into that chamber of the revolver.", 50);
        typeOut("You then spin the chamber to randomize the position.", 50);
        typeOut("Close it, take a deep breath...", 75);
        typeOut("And pull the trigger.", 100);
        typeOut("May luck be on your side.", 75);
        System.out.println();  // Just some breathing space

        System.out.print("Enter amount of players: ");
        int players = scanner.nextInt();

        new MyGame().play(players);
    }

    // Helper method to print slowly like in console games
    public static void typeOut(String text, int delayMillis) throws InterruptedException {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            Thread.sleep(delayMillis);
        }
        System.out.println();
    }
}
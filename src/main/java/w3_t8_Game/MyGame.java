package w3_t8_Game;

import java.util.ArrayList;
import java.util.Scanner;

public class MyGame extends Game{
    Scanner sc = new Scanner(System.in);
    int bulletVar;
    int chamberPosition;
    int lifeCounter;
    ArrayList<Player> players = new ArrayList<>();

    public void initializeGame(int numberOfPlayers){
        for (int i = 1; i <= numberOfPlayers; i++) {
            String name = "Player " + i;
            players.add(new Player(name));
        }
        lifeCounter = numberOfPlayers;
    }

    public boolean endOfGame(){
        return lifeCounter < 2;
    }

    public void playSingleTurn(int player){
        // Show player states
        System.out.println("\nCurrent player statuses:");
        for (Player p : players) {
            String state = p.getPlayerState() ? "alive" : "💀 dead";
            System.out.printf("%s is %s\n", p.getName(), state);
        }

        Player currentPlayer = players.get(player);

        if (!currentPlayer.getPlayerState()) {
            System.out.println(currentPlayer.getName() + " is already dead. Skipping turn.");
            return;
        }

        // Ask player where to load the bullet
        System.out.printf("\n%s, choose the chamber number to load the bullet (1-6): ", currentPlayer.getName());
        bulletVar = Math.max(1, Math.min(sc.nextInt(), 6));
        sc.nextLine(); // consume leftover newline

        // Spin the chamber
        System.out.println("Press Enter to spin the chamber...");
        sc.nextLine();
        chamberPosition = (int) (Math.random() * 6 + 1);

        // Pull the trigger
        System.out.println("Press Enter to pull the trigger...");
        sc.nextLine();

        // Check if the bullet fires
        if (chamberPosition == bulletVar) {
            System.out.println("💥 BANG! " + currentPlayer.getName() + " is dead.");
            currentPlayer.setPlayerState(false);
            lifeCounter--;
        } else {
            System.out.println("😅 Click... " + currentPlayer.getName() + " survives.");
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void displayWinner(){
        String winner = players.stream()
                .filter(Player::getPlayerState)
                .map(Player::getName)
                .findFirst()
                .orElse("No one");

        System.out.println("The winner is: " + winner);
    }

}

package w3_t8_Game;

public class Player {
    private final String name;
    private boolean playerState = true;

    Player(String name) {
        this.name = name;
    }

    public void setPlayerState(boolean playerState) {
        this.playerState = playerState;
    }

    public String getName() {
        return name;
    }

    public boolean getPlayerState() {
        return playerState;
    }
}

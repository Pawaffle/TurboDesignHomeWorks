package w3_t7_gameChar;

public abstract class LevelState {
    private Character character;

    public LevelState(Character character) {
        this.character = character;
    }

    public Character getMachine() {
        return this.character;
    }

    abstract void action();
}

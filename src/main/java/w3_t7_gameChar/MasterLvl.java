package w3_t7_gameChar;

public class MasterLvl extends ExpertLvl {

    public MasterLvl(Character newCharacter) {
        super(newCharacter);
        this.getMachine().setLevel(charLevel.MASTER);
    }

    @Override
    public void action() {
        System.out.println("Congratulations! You've reached MASTER level. Game Over.");
        System.exit(0);
    }
}

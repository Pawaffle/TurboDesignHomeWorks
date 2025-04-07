package w3_t7_gameChar;

public class NoviceLvl extends LevelState {

    public NoviceLvl(Character newCharacter) {
        super(newCharacter);
        this.getMachine().setLevel(charLevel.NOVICE);
    }

    public void train() {
        int newExp = (int) (Math.random() * 10 + 5); // Slight boost for realism
        System.out.println("Training... Gained " + newExp + " XP.");
        this.getMachine().addExp(newExp);
    }

    public void action() {
        String[] options = {"Train"};
        int choice = this.getMachine().readUserChoice(options);
        switch (choice) {
            case 1 -> train();
            default -> System.out.println("Invalid choice.");
        }
    }
}

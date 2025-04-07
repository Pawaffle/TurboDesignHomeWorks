package w3_t7_gameChar;

public class IntermediateLvl extends NoviceLvl {

    public IntermediateLvl(Character newCharacter) {
        super(newCharacter);
        this.getMachine().setLevel(charLevel.INTERMEDIATE);
    }

    public void meditate() {
        int hpGain = (int) (Math.random() * 10 + 5);
        System.out.println("Meditating... Gained " + hpGain + " HP.");
        this.getMachine().addHp(hpGain);
    }

    @Override
    public void action() {
        String[] options = {"Train", "Meditate"};
        int choice = this.getMachine().readUserChoice(options);
        switch (choice) {
            case 1 -> train();
            case 2 -> meditate();
            default -> System.out.println("Invalid choice.");
        }
    }
}

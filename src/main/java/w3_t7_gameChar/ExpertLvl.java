package w3_t7_gameChar;

public class ExpertLvl extends IntermediateLvl {

    public ExpertLvl(Character newCharacter) {
        super(newCharacter);
        this.getMachine().setLevel(charLevel.EXPERT);
    }

    public void fight() {
        int expGain = (int) (Math.random() * 10 + 10); // Boosted XP
        int hpLoss = (int) (Math.random() * 10 + 5);
        System.out.println("Fighting... Gained " + (expGain * 2) + " XP but lost " + hpLoss + " HP.");
        this.getMachine().addExp(expGain * 2);
        this.getMachine().addHp(-hpLoss);
    }

    @Override
    public void action() {
        String[] options = {"Train", "Meditate", "Fight"};
        int choice = this.getMachine().readUserChoice(options);
        switch (choice) {
            case 1 -> train();
            case 2 -> meditate();
            case 3 -> fight();
            default -> System.out.println("Invalid choice.");
        }
    }
}

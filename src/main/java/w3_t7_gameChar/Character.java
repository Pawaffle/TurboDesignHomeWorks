package w3_t7_gameChar;

import java.util.Scanner;

public class Character {
    private static Scanner scanner = new Scanner(System.in);
    private LevelState state;
    private String name;
    private charLevel level;
    private int exp;
    private int hp;



    public Character(String name)
    {
        this.name = name;
        state = new NoviceLvl(this);
    }

    public void play() {
        while (true) {
            if (state == null) {
                // should never happen
                System.out.println("Machine out of order");
                return;
            }
            state.action();
        }
    }

    public void setState(LevelState state) {
        this.state = state;
    }

    public void setLevel(charLevel level) {
        this.level = level;
    }

    public void addExp(int amount) {
        this.exp += amount;
        determineLevel(this.exp);
    }

    public void determineLevel(int exp) {
        if (exp < 100)  changeLevel(charLevel.NOVICE);
        else if (exp < 200) changeLevel(charLevel.INTERMEDIATE);
        else if (exp < 300) changeLevel(charLevel.EXPERT);
        else changeLevel(charLevel.MASTER);
    }

    public void changeLevel(charLevel level) {
        this.level = level;
        System.out.println("Congratulation! Now your level is " + level);
        switch (level) {
            case NOVICE -> state = new NoviceLvl(this);
            case INTERMEDIATE -> state = new IntermediateLvl(this);
            case EXPERT -> state = new ExpertLvl(this);
            case MASTER -> state = new MasterLvl(this);
        }
    }

    public void addHp(int amount) {
        this.hp += amount;
        if (this.hp < 0) this.hp = 0; // prevent negative HP
    }

    public double getExp() {
        return exp;
    }


    public int readUserChoice(String[] options) {
        // print options
        System.out.printf("\n%s %s level: %d exp, %d hp,\nSelect an option:\n", this.name, this.level, this.exp, this.hp);
        for (int i = 1; i <= options.length; i++) {
            System.out.println(i + ". " + options[i-1]);
        }
        // read user input
        return scanner.nextInt();
    }
}

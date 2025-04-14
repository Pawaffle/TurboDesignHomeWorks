package w4_t11_historyTrick;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Memento implements IMemento {
    private int[] options;
    private boolean isSelected;
    private String timestamp;

    public Memento(int[] options, boolean isSelected) {
        this.options = options.clone(); // Copy options array
        this.isSelected = isSelected;
        System.out.println("Memento created");

        // Add timestamp
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.timestamp = LocalDateTime.now().format(formatter);
    }

    public int[] getOptions() {
        return options;
    }

    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public Memento copy() {
        return new Memento(this.options, this.isSelected);
    }

    @Override
    public String toString() {
        return ("options: " + options[0] + " " + options[1] + " " + options[2]);
    }

    @Override
    public String getTimestamp() {
        return timestamp;
    }
}

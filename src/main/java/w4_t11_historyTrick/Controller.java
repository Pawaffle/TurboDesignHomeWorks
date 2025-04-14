package w4_t11_historyTrick;

import java.util.ArrayList;
import java.util.List;

public class  Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history; // Memento history
    private int position;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.position = -1;
        saveToHistory();
    }

    public void setOption(int optionNumber, int choice) {
        model.setOption(optionNumber, choice);
        saveToHistory();
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        model.setIsSelected(isSelected);
        saveToHistory();
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (position > 0) {
            System.out.println("Past memento found in history");
            position --;
            evaluatePosition();
        }
    }

    public void redo() {
        if (position < history.size() - 1) {
            System.out.println("Future memento found in history");
            position ++;
            evaluatePosition();
        }
    }

    public void evaluatePosition() {
        IMemento historyRef = history.get(position);
        model.restoreState(historyRef.copy());
        gui.updateGui();
    }

    private void saveToHistory() {
        if (position < history.size() - 1) {
            history = new ArrayList<>(history.subList(0, position + 1));
        }
        position ++;
        IMemento currentState = model.createMemento();
        history.add(currentState);
        System.out.println(history);
        System.out.println(position);
    }
}

// Why get - have references ?
// Why we need to use IMemento ?

package w4_t11_historyTrick;

import java.util.ArrayList;
import java.util.List;

public class  Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history; // Memento history
    private List<IMemento> futureHistory;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.futureHistory = new ArrayList<>();
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
        if (history.size() > 1) {
            IMemento currentState = history.remove(history.size() - 1);
            futureHistory.add(currentState);
            IMemento previousState = history.remove(history.size() - 1);
            model.restoreState(previousState);
            saveToHistory();
            gui.updateGui();
            System.out.println(history);

        }
    }

    public void redo() {
        if (!futureHistory.isEmpty()) {
            System.out.println("Future memento found in history");
            IMemento someState = futureHistory.remove(futureHistory.size() - 1);
            history.add(someState);
            model.restoreState(someState);
            gui.updateGui();
        }
    }

    private void saveToHistory() {
        if (!futureHistory.isEmpty()) {
            futureHistory = new ArrayList<>();
        }
        IMemento currentState = model.createMemento();
        history.add(currentState);
        System.out.println(history);
    }
}

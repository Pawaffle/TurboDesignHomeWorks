package w4_t11_historyTrick;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class  Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history; // Memento history
    private int position;
    Stage historyStage;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.position = -1;
        this.historyStage = new Stage();
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
        historyStage.close();
        position ++;
        IMemento currentState = model.createMemento();
        history.add(currentState);
        //  System.out.println(history);
        //  System.out.println(position);
    }

    public void showHistoryWindow() {
        // Step 1: Create a list of formatted descriptions
        List<String> historyItems = new ArrayList<>();
        for (int i = history.size() - 1; i >= 0; i--) {
            IMemento memento = history.get(i);
            String timestamp = memento.getTimestamp();
            String description = "State " + (i + 1) + " - " + timestamp;
            historyItems.add(description);
        }

        // Step 2: Create observable list from historyItems
        ObservableList<String> observableHistory = FXCollections.observableArrayList(historyItems);

        // Step 3: Create the ListView using the formatted strings
        ListView<String> listView = new ListView<>(observableHistory);

        listView.setOnMouseClicked(event -> {
            int selectedIndex = listView.getSelectionModel().getSelectedIndex();
            if (selectedIndex != -1) {
                // Map back to the original history index since we reversed the order
                int mappedIndex = history.size() - 1 - selectedIndex;
                position = mappedIndex;
                evaluatePosition();
            }
        });

        VBox layout = new VBox(listView);
        layout.setPadding(new Insets(10));
        layout.setSpacing(10);
        Scene scene = new Scene(layout, 300, 400);
        historyStage.setTitle("History");
        historyStage.setScene(scene);
        historyStage.show();
    }
}

// Why get - have references ?
// Why we need to use IMemento ?

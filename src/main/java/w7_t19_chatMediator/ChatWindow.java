package w7_t19_chatMediator;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

// JavaFX UI for each chat client
public class ChatWindow {
  private Stage stage;
  private TextArea chatArea;
  private TextField messageField;
  private ComboBox<String> recipientSelector;
  private Button sendButton;
  private ChatClient client;
  private ChatMediator mediator;

  public ChatWindow(ChatClient client, ChatMediator mediator) {
    this.client = client;
    this.mediator = mediator;

    // Create JavaFX components
    stage = new Stage();
    stage.setTitle("Chat - " + client.getName());

    BorderPane root = new BorderPane();
    root.setPadding(new Insets(10));

    // Chat display area
    chatArea = new TextArea();
    chatArea.setEditable(false);
    chatArea.setWrapText(true);
    root.setCenter(chatArea);

    // Bottom controls
    HBox controls = new HBox(10);
    controls.setPadding(new Insets(10, 0, 0, 0));

    // Recipient selector
    recipientSelector = new ComboBox<>();
    updateRecipientList();

    // Message input field
    messageField = new TextField();
    messageField.setPrefWidth(300);
    messageField.setPromptText("Type your message here...");

    // Send button
    sendButton = new Button("Send");
    sendButton.setOnAction(e -> sendMessage());

    // Add components to controls
    controls.getChildren().addAll(new Label("To:"), recipientSelector, messageField, sendButton);
    root.setBottom(controls);

    // Set up the scene
    Scene scene = new Scene(root, 500, 400);
    stage.setScene(scene);

    // Handle window close
    stage.setOnCloseRequest(e -> {
      mediator.removeObserver(client);
    });
  }

  public void show() {
    stage.show();
  }

  public void displayMessage(String message) {
    // Ensure UI updates happen on the JavaFX application thread
    Platform.runLater(() -> {
      chatArea.appendText(message + "\n");
    });
  }

  public void displaySystemMessage(String message) {
    // Ensure UI updates happen on the JavaFX application thread
    Platform.runLater(() -> {
      chatArea.appendText("[SYSTEM] " + message + "\n");
    });
  }

  private void sendMessage() {
    String message = messageField.getText().trim();
    String recipient = recipientSelector.getValue();

    if (!message.isEmpty() && recipient != null) {
      client.sendMessage(message, recipient);
      messageField.clear();
      updateRecipientList(); // Update recipient list after sending
    }
  }

  public void updateRecipientList() {
    String currentSelection = recipientSelector.getValue();
    recipientSelector.getItems().clear();
    recipientSelector.getItems().addAll(mediator.getClientNames());

    // Filter out the current client's name
    recipientSelector.getItems().removeIf(name -> name.equals(client.getName()));

    // Restore previous selection if it still exists
    if (currentSelection != null && recipientSelector.getItems().contains(currentSelection)) {
      recipientSelector.setValue(currentSelection);
    } else if (!recipientSelector.getItems().isEmpty()) {
      recipientSelector.setValue(recipientSelector.getItems().get(0));
    }
  }
}

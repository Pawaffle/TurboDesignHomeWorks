package w7_t19_chatMediator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Main application class
public class MainApplication extends Application {
  private ChatMediator mediator;
  private ChatWindowFactory factory;

  @Override
  public void start(Stage primaryStage) {
    // Create the mediator
    mediator = new ChatMediatorImpl();
    factory = new ChatWindowFactory(mediator);

    // Set up the main window
    primaryStage.setTitle("Chat Application");

    VBox root = new VBox(10);
    root.setPadding(new Insets(20));

    Label titleLabel = new Label("Chat Application");
    titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

    Label instructionLabel = new Label("Enter a username to create a new chat window:");

    TextField usernameField = new TextField();
    usernameField.setPromptText("Username");

    Button createButton = new Button("Create Chat Window");
    createButton.setOnAction(e -> {
      String username = usernameField.getText().trim();
      if (!username.isEmpty()) {
        ChatWindow window = factory.createChatWindow(username);
        window.show();
        usernameField.clear();
      }
    });

    // Add components to the root
    root.getChildren().addAll(titleLabel, instructionLabel, usernameField, createButton);

    // Set up the scene
    Scene scene = new Scene(root, 400, 200);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}


package w9_t22_pixelComrade;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import w9_t22_pixelComrade.commanders.*;

public class GUI extends Application {

  private Model myModel;
  private final int DISPLAY_SIZE = 8;
  private final int PIXEL_SIZE = 50;
  private Canvas canvas;

  @Override
  public void start(Stage primaryStage) {
    myModel = new Model(DISPLAY_SIZE);
    int canvasSize = DISPLAY_SIZE * PIXEL_SIZE;

    // Create main layout
    VBox root = new VBox(10);
    root.setPadding(new Insets(15));
    root.setAlignment(Pos.CENTER);

    // Title
    Label titleLabel = new Label("Pixel Comrade Editor");
    titleLabel.setFont(Font.font("System", FontWeight.BOLD, 18));

    // Canvas for drawing
    canvas = new Canvas(canvasSize, canvasSize);
    drawGrid(canvas.getGraphicsContext2D());

    // Instructions
    Label instructionsLabel = new Label(
        "Use arrow keys to move cursor, Space to toggle pixels"
    );

    // Buttons
    HBox buttonBar = new HBox(10);
    buttonBar.setAlignment(Pos.CENTER);

    Button generateButton = new Button("Create Code");
    generateButton.setFocusTraversable(false); // Prevent focus traversal
    generateButton.setOnAction(e -> {
      Command generateCommand = new GenerateCodeCommand(myModel);
      generateCommand.execute();
    });

    Button clearButton = new Button("Clear Grid");
    clearButton.setFocusTraversable(false); // Prevent focus traversal
    clearButton.setOnAction(e -> {
      myModel = new Model(DISPLAY_SIZE);
      drawGrid(canvas.getGraphicsContext2D());
    });

    buttonBar.getChildren().addAll(generateButton, clearButton);

    // Add all components to root
    root.getChildren().addAll(titleLabel, canvas, instructionsLabel, buttonBar);
    VBox.setVgrow(canvas, Priority.ALWAYS);

    // Create scene
    Scene scene = new Scene(root);

    // Handle key events at the scene level
    scene.addEventFilter(KeyEvent.KEY_PRESSED, e -> {
      Command command = null;

      if (e.getCode() == KeyCode.UP) {
        command = new MoveCursorUpCommand(myModel);
        e.consume(); // Prevent event from propagating
      } else if (e.getCode() == KeyCode.DOWN) {
        command = new MoveCursorDownCommand(myModel);
        e.consume();
      } else if (e.getCode() == KeyCode.LEFT) {
        command = new MoveCursorLeftCommand(myModel);
        e.consume();
      } else if (e.getCode() == KeyCode.RIGHT) {
        command = new MoveCursorRightCommand(myModel);
        e.consume();
      } else if (e.getCode() == KeyCode.SPACE) {
        command = new TogglePixelCommand(myModel);
        e.consume();
      }

      if (command != null) {
        command.execute();
        drawGrid(canvas.getGraphicsContext2D());
      }
    });

    // Set up stage
    primaryStage.setScene(scene);
    primaryStage.setTitle("Pixel Comrade");
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  private void drawGrid(GraphicsContext gc) {
    // Clear the canvas
    gc.clearRect(0, 0, DISPLAY_SIZE * PIXEL_SIZE, DISPLAY_SIZE * PIXEL_SIZE);

    // Draw background
    gc.setFill(Color.LIGHTGRAY);
    gc.fillRect(0, 0, DISPLAY_SIZE * PIXEL_SIZE, DISPLAY_SIZE * PIXEL_SIZE);

    // Draw the grid and filled pixels
    for (int row = 0; row < DISPLAY_SIZE; row++) {
      for (int col = 0; col < DISPLAY_SIZE; col++) {
        // Draw cell background
        if (myModel.matrix[row][col] == 1) {
          gc.setFill(Color.BLACK);
        } else {
          gc.setFill(Color.WHITE);
        }

        // Draw cell with a small margin for grid lines
        gc.fillRect(
            col * PIXEL_SIZE + 1,
            row * PIXEL_SIZE + 1,
            PIXEL_SIZE - 2,
            PIXEL_SIZE - 2
        );
      }
    }

    // Draw the cursor with a distinct color and thicker stroke
    gc.setStroke(Color.RED);
    gc.setLineWidth(3);
    gc.strokeRect(
        myModel.positionY * PIXEL_SIZE + 2,
        myModel.positionX * PIXEL_SIZE + 2,
        PIXEL_SIZE - 4,
        PIXEL_SIZE - 4
    );
    gc.setLineWidth(1); // Reset line width
  }

  public static void main(String[] args) {
    launch();
  }
}

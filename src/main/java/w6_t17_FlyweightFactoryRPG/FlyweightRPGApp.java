package w6_t17_FlyweightFactoryRPG;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import w1_t1_factory.tiles.Tile;
import w6_t17_FlyweightFactoryRPG.maps.CityMapFlyweight;
import w6_t17_FlyweightFactoryRPG.maps.WildernessMapFlyweight;
import w6_t17_FlyweightFactoryRPG.maps.MapBase;

public class FlyweightRPGApp extends Application {
  private static final int TILE_SIZE = 50;
  private static final int MAP_SIZE = 10; // Adjust map size as needed
  private MapBase map;

  @Override
  public void start(Stage primaryStage) {
    // map = new CityMapFlyweight(MAP_SIZE);
    map = new WildernessMapFlyweight(MAP_SIZE);
    int canvasSize = TILE_SIZE * map.getSize();

    Canvas canvas = new Canvas(canvasSize, canvasSize);
    GraphicsContext gc = canvas.getGraphicsContext2D();

    drawMap(gc);

    StackPane root = new StackPane(canvas);
    primaryStage.setScene(new Scene(root));
    primaryStage.setTitle("Flyweight RPG Map");
    primaryStage.show();
  }

  private void drawMap(GraphicsContext gc) {
    for (int i = 0; i < map.getSize(); i++) {
      for (int j = 0; j < map.getSize(); j++) {
        Tile tile = map.getTile(i, j);
        Image tileImg = TileGraphicFactory.getTileImage(tile.getType());
        gc.drawImage(tileImg, j * TILE_SIZE, i * TILE_SIZE, TILE_SIZE, TILE_SIZE);
      }
    }
  }
}
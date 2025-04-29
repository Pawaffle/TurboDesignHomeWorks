package w6_t17_FlyweightFactoryRPG;


import javafx.scene.image.Image;
import java.util.HashMap;
import java.util.Map;

class TileGraphicFactory {
  private static final Map<String, Image> tileImages = new HashMap<>();

  public static Image getTileImage(String tileType) {
    if (!tileImages.containsKey(tileType)) {

      Image image = new Image(TileGraphicFactory.class.getResourceAsStream("/" + tileType + ".png"));
      tileImages.put(tileType, image);
    }
    return tileImages.get(tileType);
  }
}

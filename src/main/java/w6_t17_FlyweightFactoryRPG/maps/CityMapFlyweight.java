package w6_t17_FlyweightFactoryRPG.maps;

import w1_t1_factory.tiles.Building;
import w1_t1_factory.tiles.Forest;
import w1_t1_factory.tiles.Road;
import w1_t1_factory.tiles.Tile;

import java.util.Random;

public class CityMapFlyweight extends MapBase {
  public CityMapFlyweight(int size) { super(size); }

  @Override
  protected Tile createTile() {
    return switch (new Random().nextInt(3)) {
      case 0 -> new Building();
      case 1 -> new Road();
      default -> new Forest();
    };
  }
}
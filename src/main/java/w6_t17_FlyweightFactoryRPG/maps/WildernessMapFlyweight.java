package w6_t17_FlyweightFactoryRPG.maps;

import w1_t1_factory.tiles.Forest;
import w1_t1_factory.tiles.Swamp;
import w1_t1_factory.tiles.Tile;
import w1_t1_factory.tiles.Water;

import java.util.Random;

public class WildernessMapFlyweight extends MapBase {
  private static final Tile[] TILE_POOL = {
      new Swamp(), new Water(), new Forest()
  };

  public WildernessMapFlyweight(int size) { super(size); }

  @Override
  protected Tile createTile() {
    return TILE_POOL[new Random().nextInt(3)];
  }
}
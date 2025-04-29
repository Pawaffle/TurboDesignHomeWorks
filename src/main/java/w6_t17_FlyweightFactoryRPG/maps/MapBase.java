package w6_t17_FlyweightFactoryRPG.maps;


import w1_t1_factory.tiles.Tile;

public abstract class MapBase {
  protected int size;
  protected Tile[][] tiles;

  public MapBase(int size) {
    this.size = size;
    tiles = new Tile[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        tiles[i][j] = createTile();
      }
    }
  }

  protected abstract Tile createTile();
  public Tile getTile(int x, int y) { return tiles[x][y]; }
  public int getSize() { return size; }
}
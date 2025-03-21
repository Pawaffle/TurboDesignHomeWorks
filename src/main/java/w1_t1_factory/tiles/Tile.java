package w1_t1_factory.tiles;

public interface Tile {

    public String getCharacter();

    // that returns the tile type as a string (e.g. "swamp", "water", "road", "forest", "building")
    public String getType();

    public void action();
}

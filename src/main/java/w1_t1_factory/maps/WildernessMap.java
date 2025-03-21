package w1_t1_factory.maps;

import w1_t1_factory.tiles.Building;
import w1_t1_factory.tiles.Forest;
import w1_t1_factory.tiles.Road;
import w1_t1_factory.tiles.Tile;

import java.util.concurrent.ThreadLocalRandom;

public class WildernessMap extends Map{

    private static final Tile[] TILE_TYPES = {
            new Building(),
            new Road(),
            new Forest()
    };

    @Override
    public Tile createTile() {
        int index = ThreadLocalRandom.current().nextInt(3); // returns 0, 1, or 2
        return TILE_TYPES[index];
    }
}

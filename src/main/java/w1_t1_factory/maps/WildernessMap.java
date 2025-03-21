package w1_t1_factory.maps;

import w1_t1_factory.tiles.*;

import java.util.concurrent.ThreadLocalRandom;

public class WildernessMap extends Map{

    // interesting example of GPT version for blazingly fast performance :D

    private static final Tile[] TILE_TYPES = {
            new Swamp(),
            new Water(),
            new Forest()
    };

    public WildernessMap(int mapSize) {
        super(mapSize);
    }

    @Override
    public Tile createTile() {
        int index = ThreadLocalRandom.current().nextInt(3); // returns 0, 1, or 2
        return TILE_TYPES[index];
    }
}

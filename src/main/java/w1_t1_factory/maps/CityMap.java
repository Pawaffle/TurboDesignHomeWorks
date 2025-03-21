package w1_t1_factory.maps;

import w1_t1_factory.tiles.Tile;
import w1_t1_factory.tiles.Forest;
import w1_t1_factory.tiles.Road;
import w1_t1_factory.tiles.Building;

import java.util.concurrent.ThreadLocalRandom;

public class CityMap extends Map {

    @Override
    public Tile createTile(){
        return switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0 -> new Building();
            case 1 -> new Road();
            default -> new Forest();
        };
    }

}

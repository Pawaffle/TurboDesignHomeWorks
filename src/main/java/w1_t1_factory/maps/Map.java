package w1_t1_factory.maps;

import w1_t1_factory.tiles.Tile;

public abstract class Map {
    int size;
    Tile[][] map;

    // My alternative for the createMap() function
    public Map(int mapSize) {
        this.size = mapSize;
        this.map = new Tile[mapSize][mapSize];

        // Generate the tiles
        for (int x = 0; x < mapSize; x++) {
            for (int y = 0; y < mapSize; y++) {
                map[x][y] = createTile();
            }
        }
    };

    // that creates a new tile of random type
    public abstract Tile createTile();

    // displays the map on the screen as a matrix of characters
    public void display(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(map[i][j].getCharacter() + " ");
            }
            System.out.println();
        }
    };

    // displays map with user position on it
    public void display(int x, int y){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (x == i && y == j) {
                    System.out.print("\uD83D\uDE04");
                } else {
                    System.out.print(map[i][j].getCharacter() + " ");
                }
            }
            System.out.println();
        }
    };

    // returns (tile) element to perform related actions
    public Tile getElement(int x, int y){
        return this.map[x][y];
    }
}


package w1_t1_factory.tiles;

public class Forest implements Tile {

    public String getCharacter(){
        return "F";
    };

    public String getType(){
        return "forest";
    };

    public void action(){
        System.out.println("action in forest");
    };
}

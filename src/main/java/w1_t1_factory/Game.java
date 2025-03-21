package w1_t1_factory;

import w1_t1_factory.maps.CityMap;
import w1_t1_factory.maps.Map;
import w1_t1_factory.maps.WildernessMap;
import w1_t1_factory.tiles.Tile;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select a map to generate");
        System.out.println("1.City");
        System.out.println("2.Wilderness");

        int mapChoice = scanner.nextInt();

        System.out.println("Enter map size to generate:");
        int mapSize = scanner.nextInt();

        Map myMap = switch (mapChoice) {
            case 1 -> new CityMap(mapSize);
            default -> new WildernessMap(mapSize);
        };


        int x = 0;
        int y = 0;
        int control = 100;
        String clear = "\n".repeat(10);

        while (control != 0){

            if(control != 5){
                System.out.print(clear);
                myMap.display(x,y);
            }

            Tile currentElement = myMap.getElement(x,y);
            control = scanner.nextInt();

            switch (control) {
                case 8:
                    x -= 1;
                    break;
                case 2:
                    x += 1;
                    break;
                case 4:
                    y -= 1;
                    break;
                case 6:
                    y += 1;
                    break;
                case 5:
                    currentElement.action();
                    break;
                default:
                    control = 0;
                    break;
            }
        }
    }
}


package test;

public class CoffeeTest {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee(); // Start with plain coffee
        System.out.println(coffee.getDescription());
        // Output: Plain coffee

        coffee = new MilkDecorator(coffee); // Add milk
        System.out.println(coffee.getDescription());
        // Output: Plain coffee with milk

        coffee = new SugarDecorator(coffee); // Then add sugar
        System.out.println(coffee.getDescription());
        // Output: Plain coffee with milk with sugar
    }
}

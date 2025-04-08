package w3_t9_sorting;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        SortingContext sortingHandler = new SortingContext(new QuickSort());

        System.out.println("Enter the amount (30-100000) of integers in array: ");
        int size = Math.max(30, Math.min(scanner.nextInt(), 100000));

        // Generate random data
        Integer[] myArray = new Integer[size];
        for (int i = 0; i < size; i++) {
            myArray[i] = rand.nextInt(100000); // values from 0 to 99,999
        }

        System.out.println("Select sorting method: ");
        System.out.println("1. Quick");
        System.out.println("2. Medium Quick");
        System.out.println("3. Slow Quick");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                sortingHandler.setStrategy(new QuickSort());
                break;
            case 2:
                sortingHandler.setStrategy(new InsertionSort());
                break;
            case 3:
                sortingHandler.setStrategy(new BubbleSort());
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        long startTime = System.nanoTime();
        Integer[] sortedArray = sortingHandler.sort(myArray);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime) / 1_000_000; // in milliseconds

        System.out.println("It took " + duration + " ms to sort " + sortedArray.length + " elements" );
        System.out.println(Arrays.toString(sortedArray));

    }
}

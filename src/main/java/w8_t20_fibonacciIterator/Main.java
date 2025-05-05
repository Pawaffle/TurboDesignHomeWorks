package w8_t20_fibonacciIterator;

import java.util.Iterator;

public class Main {
  static int loop = 10;

  public static void main(String[] args) {
    Sequence fibSequence = new FibonacciSequence();
    Iterator<Integer> iterator = fibSequence.iterator();

    System.out.printf("First %d Fibonacci numbers: \n", loop);
    for (int i = 0; i < loop; i++) {
      System.out.print(iterator.next() + " ");
    }
  }
}
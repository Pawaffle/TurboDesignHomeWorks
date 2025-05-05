package w8_t20_fibonacciIterator;

import java.util.Iterator;

public class FibonacciSequence implements Sequence {

  /**
   * Based on the idea that iterator should separate calculations from number to better scalability
   * I'm storing number itself in the iterator, but calculations made in Sequence
   * I'm trying to achieve better scalability and possibility run multiple iterators in the same time.
   *
   * @param current the current Fibonacci number
   * @return the next larger Fibonacci number
   * @throws IllegalArgumentException if the number is not in the Fibonacci sequence
   */
  public int getNextFibonacci(int current) {
    int a = 1;
    int b = 1;

    if (current == 1) return 2;

    while (b <= current) {
      int temp = a + b;
      a = b;
      b = temp;

      if (a == current) {
        return b;
      }
    }

    throw new IllegalArgumentException("Number " + current + " is not a Fibonacci number");
  }

  @Override
  public Iterator<Integer> iterator() {
    return new FibonacciIterator(this);
  }
}

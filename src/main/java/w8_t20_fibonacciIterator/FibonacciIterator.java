package w8_t20_fibonacciIterator;

import java.util.Iterator;

public class FibonacciIterator implements Iterator<Integer> {
  private int current = 1;
  private boolean first = true; // to return 1 twice at the beginning
  private final FibonacciSequence sequence;

  public FibonacciIterator(FibonacciSequence sequence) {
    this.sequence = sequence;
  }

  @Override
  public boolean hasNext() {
    return true; // potentially infinite sequence
  }

  @Override
  public Integer next() {
    if (first) {
      first = false;
      return current;
    }
    int result = current;
    current = sequence.getNextFibonacci(current);
    return result;
  }
}
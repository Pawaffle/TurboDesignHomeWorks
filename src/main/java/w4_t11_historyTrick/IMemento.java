package w4_t11_historyTrick;

public interface IMemento {
    // memento metadata methods
    IMemento copy();

  // New method for history window
  String getTimestamp();
}

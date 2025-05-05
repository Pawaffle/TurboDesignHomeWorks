package w7_t19_chatMediator;

// Subject interface
public interface Subject {
  void registerObserver(Observer observer);
  void removeObserver(Observer observer);
  void notifyObservers(String message, String sender);
  void notifySystemMessage(String message);
}


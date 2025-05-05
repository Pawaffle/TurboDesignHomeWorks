package w7_t19_chatMediator;

// Observer interface
public interface Observer {
  void update(String message, String sender);
  void updateSystemMessage(String message);
}

package w7_t19_chatMediator;

// Interface for Chat Clients
public interface ChatClient extends Observer {
  void sendMessage(String message, String recipient);
  void receiveMessage(String message, String sender);
  String getName();
  void updateRecipientList();
}

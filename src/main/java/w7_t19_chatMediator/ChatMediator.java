package w7_t19_chatMediator;

// Interface for the Mediator
public interface ChatMediator extends Subject {
  void sendMessage(String message, String sender, String recipient);
  String[] getClientNames();
  void notifyUpdateRecipientLists();
}

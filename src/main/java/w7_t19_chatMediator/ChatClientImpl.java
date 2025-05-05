package w7_t19_chatMediator;

// Concrete implementation of ChatClient
public class ChatClientImpl implements ChatClient {
  private ChatMediator mediator;
  private String name;
  private ChatWindow window;

  public ChatClientImpl(ChatMediator mediator, String name) {
    this.mediator = mediator;
    this.name = name;
  }

  public void setWindow(ChatWindow window) {
    this.window = window;
  }

  @Override
  public void sendMessage(String message, String recipient) {
    mediator.sendMessage(message, name, recipient);
    // Also display the message in sender's window
    window.displayMessage("You to " + recipient + ": " + message);
  }

  @Override
  public void receiveMessage(String message, String sender) {
    window.displayMessage(sender + ": " + message);
  }

  @Override
  public void update(String message, String sender) {
    receiveMessage(message, sender);
  }

  @Override
  public void updateSystemMessage(String message) {
    if (window != null) {
      window.displaySystemMessage(message);
    }
  }

  @Override
  public void updateRecipientList() {
    window.updateRecipientList();
  }

  @Override
  public String getName() {
    return name;
  }
}

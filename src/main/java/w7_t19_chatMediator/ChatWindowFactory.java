package w7_t19_chatMediator;

// Factory for creating chat windows
import java.util.ArrayList;
import java.util.List;

public class ChatWindowFactory {
  private ChatMediator mediator;
  private List<ChatWindow> windows = new ArrayList<>();

  public ChatWindowFactory(ChatMediator mediator) {
    this.mediator = mediator;
  }

  public ChatWindow createChatWindow(String username) {
    // Create client
    ChatClientImpl client = new ChatClientImpl(mediator, username);

    // Create window and set it in the client
    ChatWindow window = new ChatWindow(client, mediator);
    client.setWindow(window);

    // Register client as an observer
    mediator.registerObserver(client);

    // Add window to the list
    windows.add(window);

    return window;
  }
}

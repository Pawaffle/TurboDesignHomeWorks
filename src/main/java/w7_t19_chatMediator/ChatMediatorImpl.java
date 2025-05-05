package w7_t19_chatMediator;

import java.util.ArrayList;
import java.util.List;

// Concrete Mediator implementation
public class ChatMediatorImpl implements ChatMediator {
  private List<Observer> observers;

  public ChatMediatorImpl() {
    this.observers = new ArrayList<>();
  }

  @Override
  public void sendMessage(String message, String sender, String recipient) {
    for (Observer observer : observers) {
      if (observer instanceof ChatClient) {
        ChatClient client = (ChatClient) observer;
        // If recipient is "All", send to everyone except sender
        if (recipient.equals("All")) {
          if (!client.getName().equals(sender)) {
            client.receiveMessage(message, sender);
          }
        }
        // Otherwise, send only to the specified recipient
        else if (client.getName().equals(recipient)) {
          client.receiveMessage(message, sender);
          break;
        }
      }
    }
  }

  @Override
  public void registerObserver(Observer observer) {
    observers.add(observer);
    if (observer instanceof ChatClient) {
      notifySystemMessage("User " + ((ChatClient) observer).getName() + " has joined the chat.");
      // Update recipient lists after a new user joins
      notifyUpdateRecipientLists();
    }
  }

  @Override
  public void removeObserver(Observer observer) {
    observers.remove(observer);
    if (observer instanceof ChatClient) {
      notifySystemMessage("User " + ((ChatClient) observer).getName() + " has left the chat.");
      // Update recipient lists after a user leaves
      notifyUpdateRecipientLists();
    }
  }

  @Override
  public void notifyObservers(String message, String sender) {
    for (Observer observer : observers) {
      observer.update(message, sender);
    }
  }

  @Override
  public void notifySystemMessage(String message) {
    for (Observer observer : observers) {
      observer.updateSystemMessage(message);
    }
  }

  @Override
  public void notifyUpdateRecipientLists() {
    for (Observer observer : observers) {
      if (observer instanceof ChatClient) {
        ((ChatClient) observer).updateRecipientList();
      }
    }
  }

  @Override
  public String[] getClientNames() {
    List<String> names = new ArrayList<>();
    names.add("All"); // First option is to send to all clients

    for (Observer observer : observers) {
      if (observer instanceof ChatClient) {
        names.add(((ChatClient) observer).getName());
      }
    }

    return names.toArray(new String[0]);
  }
}

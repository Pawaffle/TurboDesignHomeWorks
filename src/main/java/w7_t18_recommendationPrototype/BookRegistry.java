package w7_t18_recommendationPrototype;

import java.util.HashMap;
import java.util.Map;

public class BookRegistry {
  private Map<String, Book> bookPrototypes = new HashMap<>();

  public void register(String key, Book book) {
    bookPrototypes.put(key, book);
  }

  public void createAndRegister(String key, String title, String author, String genre, int year) {
    Book book = new Book(title, author, genre, year);
    if (bookPrototypes.containsKey(key)) {
      System.out.println("A book with key '" + key + "' successfully overwritten.");
    }
    register(key, book);
  }

  public Book getClone(String key) {
    Book prototype = bookPrototypes.get(key);
    if (prototype != null) {
      return prototype.clone();
    }
    throw new IllegalArgumentException("No book prototype found for key: " + key);
  }

  public Book getOriginal(String key) {
    Book book = bookPrototypes.get(key);
    if (book != null) return book;
    throw new IllegalArgumentException("No book prototype found for key: " + key);
  }

  public void listBooks() {
    System.out.println("Available Book Prototypes:");
    for (Map.Entry<String, Book> entry : bookPrototypes.entrySet()) {
      System.out.println("- [" + entry.getKey() + "] " + entry.getValue());
    }
  }
}


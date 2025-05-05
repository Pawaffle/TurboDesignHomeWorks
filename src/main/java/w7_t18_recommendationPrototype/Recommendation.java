package w7_t18_recommendationPrototype;

import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable {
  private String targetAudience;
  private List<Book> books = new ArrayList<>();

  public Recommendation(String targetAudience) {
    this.targetAudience = targetAudience;
  }

  public void addBook(Book book) {
    books.add(book);
  }

  public void removeBook(Book book) {
    books.remove(book);
  }

  public void setTargetAudience(String targetAudience) {
    this.targetAudience = targetAudience;
  }

  public String getTargetAudience() {
    return targetAudience;
  }

  public List<Book> getBooks() {
    return books;
  }

  @Override
  public Recommendation clone() {
    Recommendation clone = new Recommendation(this.targetAudience);
    for (Book book : this.books) {
      clone.addBook(book.clone());
    }
    return clone;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Audience: " + targetAudience + "\nBooks:\n");
    for (Book book : books) {
      sb.append(" - ").append(book).append("\n");
    }
    return sb.toString();
  }
}

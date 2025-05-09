package w7_t18_recommendationPrototype;

public class Book implements Cloneable {
  private String title;
  private String author;
  private String genre;
  private int publicationYear;

  public Book(String title, String author, String genre, int publicationYear) {
    this.title = title;
    this.author = author;
    this.genre = genre;
    this.publicationYear = publicationYear;
  }

  @Override
  public Book clone() {
    try {
      return (Book) super.clone(); // shallow clone is fine (fields are immutable or primitives)
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }

  @Override
  public String toString() {
    return "\"" + title + "\" by " + author + " [" + genre + ", " + publicationYear + "]";
  }
}

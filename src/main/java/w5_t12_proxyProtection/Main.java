package w5_t12_proxyProtection;

public class Main {
  public static void main(String[] args) {
    Library library = new Library();

    // Users
    User alice = new User("alice");
    User bob = new User("bob");

    // Add documents
    library.addUnprotectedDocument(1, "Public Document Content");
    library.addProtectedDocument(2, "Secret Document Content", new String[]{"alice"});

    try {
      System.out.println("Alice accessing public doc: " + library.getDocument(1).getContent(alice));
      System.out.println("Alice accessing protected doc: " + library.getDocument(2).getContent(alice));
      System.out.println("Bob accessing protected doc: " + library.getDocument(2).getContent(bob));
    } catch (AccessDeniedException e) {
      System.out.println(e.getMessage());
    }
  }
}

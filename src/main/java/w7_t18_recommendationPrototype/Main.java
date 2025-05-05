package w7_t18_recommendationPrototype;

public class Main {
  public static void main(String[] args) {
    // Step 1: Set up the Book Registry
    BookRegistry bookRegistry = new BookRegistry();
    bookRegistry.createAndRegister("b1", "1984", "George Orwell", "Dystopian", 1949);
    bookRegistry.createAndRegister("b2", "To Kill a Mockingbird", "Harper Lee", "Classic", 1960);
    bookRegistry.createAndRegister("b3", "The Hobbit", "J.R.R. Tolkien", "Fantasy", 1937);

    System.out.println();
    bookRegistry.listBooks();
    System.out.println();

    // Step 2: Set up the Recommendation Registry
    RecommendationRegistry recommendationRegistry = new RecommendationRegistry();
    Recommendation teensRec = new Recommendation("Teen Readers");
    teensRec.addBook(bookRegistry.getClone("b2"));
    teensRec.addBook(bookRegistry.getClone("b3"));
    recommendationRegistry.register("teens", teensRec);

    Recommendation dystopiaRec = new Recommendation("Dystopia Lovers");
    dystopiaRec.addBook(bookRegistry.getClone("b1"));
    recommendationRegistry.register("dystopia", dystopiaRec);

    recommendationRegistry.listRecommendations();
    System.out.println();

    // Step 3: Clone a recommendation and modify it
    Recommendation clonedForYoungAdults = recommendationRegistry.getClone("teens");
    clonedForYoungAdults.setTargetAudience("Young Adults");
    clonedForYoungAdults.addBook(bookRegistry.getClone("b1")); // Adding dystopian book

    // Step 4: Display all recommendations
    System.out.println("Original 'teens' Recommendation:");
    System.out.println(recommendationRegistry.getOriginal("teens"));

    System.out.println("Cloned and Modified 'young adults' Recommendation:");
    System.out.println(clonedForYoungAdults);

    // Optionally register the new one
    recommendationRegistry.register("youngAdults", clonedForYoungAdults);
  }
}

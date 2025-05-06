package w8_t21_facadeJoke;

public class Main {
  public static void main(String[] args) {
    try {
      // Using the facade to get a Chuck Norris joke
      ApiFacade jokeFacade = new ApiFacade("https://api.chucknorris.io/jokes/random", "value");
      String joke = jokeFacade.getResult();
      System.out.println("Chuck Norris Joke: " + joke);

      // Using the same facade to get base currency from FX API
      ApiFacade fxFacade = new ApiFacade("https://open.er-api.com/v6/latest", "base_code");
      String baseCurrency = fxFacade.getResult();
      System.out.println("FX API Base Currency: " + baseCurrency);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

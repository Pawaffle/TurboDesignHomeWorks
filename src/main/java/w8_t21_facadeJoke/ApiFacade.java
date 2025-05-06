package w8_t21_facadeJoke;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ApiFacade {
  private final String url;
  private final String attribute;
  private final JokeClient client;

  public ApiFacade(String url, String attribute) {
    this.url = url;
    this.attribute = attribute;
    this.client = new JokeClient();
  }

  public String getResult() throws Exception {
    String json = client.getJsonFromApi(url);

    JSONParser parser = new JSONParser();
    JSONObject jsonObject = (JSONObject) parser.parse(json);

    if (!jsonObject.containsKey(attribute)) {
      throw new IllegalArgumentException("Attribute '" + attribute + "' not found in JSON.");
    }

    return jsonObject.get(attribute).toString();
  }
}
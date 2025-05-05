package w7_t18_recommendationPrototype;

import java.util.HashMap;
import java.util.Map;

public class RecommendationRegistry {
  private Map<String, Recommendation> recommendationPrototypes = new HashMap<>();

  public void register(String key, Recommendation recommendation) {
    recommendationPrototypes.put(key, recommendation);
  }

  public void createAndRegister(String key, String audience) {
    Recommendation recommendation = new Recommendation(audience);
    if (recommendationPrototypes.containsKey(key)) {
      System.out.println("A recommendation with key '" + key + "' successfully overwritten.");
    }
    register(key, recommendation);
  }

  public Recommendation getClone(String key) {
    Recommendation prototype = recommendationPrototypes.get(key);
    if (prototype != null) {
      return prototype.clone();
    }
    throw new IllegalArgumentException("No recommendation prototype found for key: " + key);
  }

  public Recommendation getOriginal(String key) {
    Recommendation recommendation = recommendationPrototypes.get(key);
    if (recommendation != null) return recommendation;
    throw new IllegalArgumentException("No recommendation prototype found for key: " + key);
  }

  public void listRecommendations() {
    System.out.println("Available Recommendation Prototypes:");
    for (Map.Entry<String, Recommendation> entry : recommendationPrototypes.entrySet()) {
      System.out.println("- [" + entry.getKey() + "] for " + entry.getValue().getTargetAudience());
    }
  }
}


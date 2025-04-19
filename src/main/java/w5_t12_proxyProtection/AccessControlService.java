package w5_t12_proxyProtection;

public class AccessControlService {

  private static volatile AccessControlService instance = null;
  hashMap<username, documentID>; // might be something not hashMap

  private AccessControlService() {
      // nothing here
  }

  public static AccessControlService getInstance() {
    if (instance == null) {
      synchronized (AccessControlService.class) {
        if (instance == null) {
          instance = new AccessControlService();
        }
      }
    }
    return instance;
  }

  boolean isAllowed(int documentID, String username) {
    // some checks here

    return false;
  }
}

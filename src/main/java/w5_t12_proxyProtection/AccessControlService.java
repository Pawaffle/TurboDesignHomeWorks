package w5_t12_proxyProtection;

import java.util.HashSet;
import java.util.Set;

public class AccessControlService {
  private static volatile AccessControlService instance = null;
  private Set<String> accessList;

  private AccessControlService() {
    accessList = new HashSet<>();
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

  public void grantAccess(String username, int documentId) {
    accessList.add(username + "#" + documentId);
  }

  public boolean isAllowed(int documentId, String username) {
    return accessList.contains(username + "#" + documentId);
  }
}

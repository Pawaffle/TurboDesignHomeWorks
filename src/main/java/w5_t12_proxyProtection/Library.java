package w5_t12_proxyProtection;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Library {
  private Map<Integer, DocumentInterface> documents = new HashMap<>();

  public void addUnprotectedDocument(int id, String content) {
    Document doc = new Document(id, new Date(), content);
    documents.put(id, doc);
  }

  public void addProtectedDocument(int id, String content, String[] allowedUsers) {
    Document realDoc = new Document(id, new Date(), content);
    DocumentProxy proxy = new DocumentProxy(realDoc);
    documents.put(id, proxy);
    AccessControlService acs = AccessControlService.getInstance();
    for (String user : allowedUsers) {
      acs.grantAccess(user, id);
    }
  }

  public DocumentInterface getDocument(int id) {
    return documents.get(id);
  }
}

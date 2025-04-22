package w5_t12_proxyProtection;

import java.util.Date;

public class DocumentProxy implements DocumentInterface {
  private Document realDocument;

  public DocumentProxy(Document realDocument) {
    this.realDocument = realDocument;
  }

  @Override
  public int getId() {
    return realDocument.getId();
  }

  @Override
  public Date getCreationDate() {
    return realDocument.getCreationDate();
  }

  @Override
  public String getContent(User user) throws AccessDeniedException {
    if (checkUserRights(user)) {
      return realDocument.getContent(user);
    } else {
      throw new AccessDeniedException("Access denied for user: " + user.getUsername());
    }
  }

  private boolean checkUserRights(User user) {
    return AccessControlService.getInstance().isAllowed(realDocument.getId(), user.getUsername());
  }
}

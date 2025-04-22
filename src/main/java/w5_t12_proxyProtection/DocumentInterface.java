package w5_t12_proxyProtection;

import java.util.Date;

public interface DocumentInterface {
  int getId();
  Date getCreationDate();
  String getContent(User user) throws AccessDeniedException;
}

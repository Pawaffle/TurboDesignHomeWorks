package w5_t12_proxyProtection;

import java.util.Date;

public class Document implements DocumentInterface {
  private int id;
  private Date creationDate;
  private String content;

  public Document(int id, Date creationDate, String content) {
    this.id = id;
    this.creationDate = creationDate;
    this.content = content;
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public Date getCreationDate() {
    return creationDate;
  }

  @Override
  public String getContent(User user) {
    return content;
  }
}

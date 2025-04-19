package w5_t12_proxyProtection;

public class User {
  String username;

  public User(String username) {
    this.username = username;
  }

  void getDocumentInformation() {
    DocumentProxy.getContent(this.username);
  }
}

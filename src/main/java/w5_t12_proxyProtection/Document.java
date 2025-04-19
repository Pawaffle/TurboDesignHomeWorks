package w5_t12_proxyProtection;

public class Document implements DocumentInterface {
  public date creationDate;
  public int uniqId;

  protected String information;

  void modifyDocument() {}

  String getInformation() {
    return information;
  }

}

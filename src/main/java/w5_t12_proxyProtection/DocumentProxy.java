package w5_t12_proxyProtection;

import java.nio.file.AccessDeniedException;

public class DocumentProxy implements DocumentInterface{

  // the only fucker that can access the documentation
  // checks the user rights from the AccessControlService


  String getContent(){
    try(checkUserRights()){

      return null

    } throw(AccessDeniedException) {

    }
  }

  boolean checkUserRights(){
    // call for the AccessControlService
    return false;
  }

  date getCreationDate(){
    return null; // returns date
  }

}

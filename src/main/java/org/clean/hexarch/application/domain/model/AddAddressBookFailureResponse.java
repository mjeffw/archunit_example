package org.clean.hexarch.application.domain.model;

public class AddAddressBookFailureResponse extends AddAddressBookResponse {
  private String responseCode;
  private String responseMsg;

  public AddAddressBookFailureResponse(String responseCode, String responseMsg) {
    this.responseCode = responseCode;
    this.responseMsg = responseMsg;
  }
}

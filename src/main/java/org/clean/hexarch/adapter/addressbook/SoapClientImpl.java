package org.clean.hexarch.adapter.addressbook;

import org.clean.hexarch.adapter.addressbook.data.ManageAddressBook;
import org.clean.hexarch.adapter.addressbook.data.ManageAddressBookResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class SoapClientImpl extends WebServiceGatewaySupport implements SoapClient {
  private String endpointUrl;

  @Override
  public ManageAddressBookResponse sendRequest(ManageAddressBook request) {
    log.debug("sendRequest() calling {} with request {}", endpointUrl, request);
    ManageAddressBookResponse response = (ManageAddressBookResponse) getWebServiceTemplate()
        .marshalSendAndReceive(endpointUrl, request);
    log.debug("sendRequest() response: {}", response);
    return response;
  }

  public String getEndpontUrl() {
    return endpointUrl;
  }

  public void setEndpointUrl(String endpointUrl) {
    this.endpointUrl = endpointUrl;
  }
}

package org.clean.hexarch.adapter.addressbook;

import org.clean.hexarch.adapter.addressbook.data.ManageAddressBook;
import org.clean.hexarch.adapter.addressbook.data.ManageAddressBookResponse;
import org.clean.hexarch.adapter.addressbook.data.types.ABActionStatus;
import org.clean.hexarch.application.domain.model.AddAddressBookFailureResponse;
import org.clean.hexarch.application.domain.model.AddAddressBookResponse;
import org.clean.hexarch.application.domain.model.AddAddressBookSuccessResponse;
import org.clean.hexarch.application.domain.model.AddressBook;
import org.clean.hexarch.application.domain.service.port.AddressBookPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PortAdapter implements AddressBookPort {
  private final SoapClient client;

  @Autowired
  public PortAdapter(SoapClient client) {
    this.client = client;
  }

  @Override
  public AddAddressBookResponse add(AddressBook book) {
    try {
      // convert from AddressBook to ManageAddressBook data
      ManageAddressBook data = toManageAddressBook(book);
      ManageAddressBookResponse rsp = client.sendRequest(data);
      AddAddressBookResponse response = toAddResponse(rsp);
      return response;
    } catch (Exception e) {
      throw new AddressServiceException();
    }
  }

  private ManageAddressBook toManageAddressBook(AddressBook book) {
    PortAddressBookExporter exporter = new PortAddressBookExporter();
    exporter.export(book);
    return exporter.get();
  }

  private AddAddressBookResponse toAddResponse(ManageAddressBookResponse rsp) {
    ABActionStatus status = rsp.getManageAddressBookReturn().getStatus().get(0);

    if (isSuccess(status.getResponseCode())) {
      return new AddAddressBookSuccessResponse();
    } else {
      return new AddAddressBookFailureResponse(status.getResponseCode(), status.getResponseMsg());
    }
  }

  private boolean isSuccess(String responseCode) {
    // TODO change to match reality
    return "SUCCESS".equals(responseCode);
  }
}

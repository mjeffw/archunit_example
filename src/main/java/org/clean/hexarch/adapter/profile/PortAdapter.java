package org.clean.hexarch.adapter.profile;

import org.clean.hexarch.application.domain.model.AddressBook;
import org.clean.hexarch.application.domain.model.Ban;
import org.clean.hexarch.application.domain.service.port.MpsPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class PortAdapter implements MpsPort {
  private SoapClient client;

  @Autowired
  public PortAdapter(SoapClient client) {
    this.client = client;
  }

  @Override
  public AddressBook getAddressBook(Ban ban) {
    // TODO Auto-generated method stub

    // call MPS and get the MpsData for the BAN
    MpsData data = client.retrieveMpsData(ban.asStringValue());

    // convert MpsData to AddressBook
    AddressBook book = toAddressBook(data);

    // return AddressBook
    return book;
  }

  private AddressBook toAddressBook(MpsData data) {
    // TODO Auto-generated method stub
    return new AddressBook();
  }
}

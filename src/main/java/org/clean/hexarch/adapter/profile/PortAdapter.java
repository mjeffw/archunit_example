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
    try {
      // call MPS and get the MpsData for the BAN
      ProfileData data = client.retrieveProfileData(ban.asStringValue());

      // convert MpsData to AddressBook
      AddressBook book = toAddressBook(data);
      return book;
    } catch (Exception e) {
      throw new ProfileServiceException();
    }
  }

  private AddressBook toAddressBook(ProfileData data) {
    return new AddressBook();
  }
}

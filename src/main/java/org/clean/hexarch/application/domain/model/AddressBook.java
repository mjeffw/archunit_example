package org.clean.hexarch.application.domain.model;

import java.util.UUID;
import java.util.function.Function;

public class AddressBook {
  private boolean addressBookExists;
  private boolean primaryMember;

  private String memberID;
  private UUID transactionID;

  public AddAddressBookResponse updateIn(Function<AddressBook, AddAddressBookResponse> addService) {
    // Business rule:
    // Add add the AddressBook to UVP if it is needed and hasn't been done already
    if (shouldBeAdded()) {
      transactionID = UUID.randomUUID();
      return addService.apply(this);
    } else {
      return new AddAddressBookNoOpResponse();
    }
  }

  private boolean shouldBeAdded() {
    return primaryMember && !addressBookExists;
  }

  public void exportTo(AddressBookExporter exporter) {
    exporter.setAddressBookExists(addressBookExists);
    exporter.setPrimaryMember(primaryMember);
    exporter.setMemberId(memberID);
    exporter.setTransactionId(transactionID);
  }
}

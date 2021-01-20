package org.clean.hexarch.application.domain.service.port;

import org.clean.hexarch.application.domain.model.AddAddressBookResponse;
import org.clean.hexarch.application.domain.model.AddressBook;

public interface AddressBookPort {
  AddAddressBookResponse add(AddressBook book);
}

package org.clean.hexarch.application.domain.service.port;

import org.clean.hexarch.application.domain.model.AddressBook;
import org.clean.hexarch.application.domain.model.Ban;

public interface MpsPort {
  AddressBook getAddressBook(Ban ban);
}

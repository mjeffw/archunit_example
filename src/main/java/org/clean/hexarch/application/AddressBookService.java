package org.clean.hexarch.application;

public interface AddressBookService {
  void handle(RegistrationNotifyEvent registrationNotifyEvent);

  void handle(UnknownEvent unknownEvent);
}

package org.clean.hexarch.adapter.addressbook;

import org.clean.hexarch.adapter.addressbook.data.ManageAddressBook;
import org.clean.hexarch.adapter.addressbook.data.ManageAddressBookResponse;

interface SoapClient {
  ManageAddressBookResponse sendRequest(ManageAddressBook request);
}

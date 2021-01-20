package org.clean.hexarch.application.domain.model;

import java.util.UUID;

/**
 * This is a clever way to export the data from a domain object without exposing
 * all of its fields via getters and setters. It inverts the dependency --
 * instead of an external object calling getters on the domain object's fields,
 * we just pass an exporter to the domain object, and the domain object itself
 * passes its data to the exporter.
 * 
 * @author jw9615
 */
public interface AddressBookExporter {
  default void export(AddressBook book) {
    book.exportTo(this);
  }

  void setAddressBookExists(boolean addressBookExists);

  void setPrimaryMember(boolean primaryMember);

  void setMemberId(String memberID);

  void setTransactionId(UUID transactionID);
}

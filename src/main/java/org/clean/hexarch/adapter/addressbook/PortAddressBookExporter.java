package org.clean.hexarch.adapter.addressbook;

import java.util.UUID;

import org.clean.hexarch.adapter.addressbook.data.ManageAddressBook;
import org.clean.hexarch.adapter.addressbook.data.ObjectFactory;
import org.clean.hexarch.adapter.addressbook.data.types.ABAction;
import org.clean.hexarch.adapter.addressbook.data.types.RequestVO;
import org.clean.hexarch.application.domain.model.AddressBookExporter;

class PortAddressBookExporter implements AddressBookExporter {
  private static final int DEL = 0;
  private static final int ADD = 1;
  private static final ObjectFactory objFactory = new ObjectFactory();
  private static final org.clean.hexarch.adapter.addressbook.data.types.ObjectFactory objFactoryForTypes = new org.clean.hexarch.adapter.addressbook.data.types.ObjectFactory();

  private final ABAction action;
  private final ManageAddressBook manageAddressBook;

  public PortAddressBookExporter() {
    manageAddressBook = objFactory.createManageAddressBook();
    action = objFactoryForTypes.createABAction();

    RequestVO requestVO = objFactoryForTypes.createRequestVO();
    requestVO.getActions().add(action);
    manageAddressBook.setRequestVO(requestVO);
  }

  public ManageAddressBook get() {
    return manageAddressBook;
  }

  @Override
  public void setAddressBookExists(boolean addressBookExists) {
    action.setAccountAction(addressBookExists ? ADD : DEL);
  }

  @Override
  public void setPrimaryMember(boolean primaryMember) {
    // ignore: No primary member indicator in ManageAddressBook
  }

  @Override
  public void setMemberId(String memberID) {
    action.setMemberID(memberID);
  }

  @Override
  public void setTransactionId(UUID transactionID) {
    manageAddressBook.getRequestVO().setTransactionID(transactionID.toString());
  }
}

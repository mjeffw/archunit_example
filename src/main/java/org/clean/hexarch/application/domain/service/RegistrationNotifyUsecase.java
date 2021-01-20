package org.clean.hexarch.application.domain.service;

import org.clean.hexarch.application.domain.model.AddAddressBookResponse;
import org.clean.hexarch.application.domain.model.AddressBook;
import org.clean.hexarch.application.domain.service.port.MpsPort;
import org.clean.hexarch.application.domain.service.port.AddressBookPort;
import org.clean.hexarch.application.domain.service.port.WorkflowPort;
import org.clean.hexarch.application.util.bus.Command;
import org.clean.hexarch.application.util.bus.Handler;

public class RegistrationNotifyUsecase implements Handler {
  private final MpsPort mps;
  private final AddressBookPort uvp;
  private final WorkflowPort workflow;

  public RegistrationNotifyUsecase(MpsPort mps, AddressBookPort uvp, WorkflowPort workflow) {
    this.mps = mps;
    this.uvp = uvp;
    this.workflow = workflow;
  }

  @Override
  public void handle(Command cmd) {
    RegistrationNotifyCommand command = (RegistrationNotifyCommand) cmd;

    try {
      AddressBook book = mps.getAddressBook(command.getBan());

      AddAddressBookResponse response = book.updateIn(uvp::add);

      workflow.send(response, command.getContext());
    } catch (Exception e) {
      // handle processing errors
    }
  }
}

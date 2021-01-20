package org.clean.hexarch.application.domain.service.registry;

import org.clean.hexarch.application.domain.service.RegistrationNotifyCommand;
import org.clean.hexarch.application.domain.service.RegistrationNotifyUsecase;
import org.clean.hexarch.application.domain.service.port.MpsPort;
import org.clean.hexarch.application.domain.service.port.AddressBookPort;
import org.clean.hexarch.application.domain.service.port.WorkflowPort;
import org.clean.hexarch.application.util.bus.Command;
import org.clean.hexarch.application.util.bus.Handler;
import org.clean.hexarch.application.util.bus.RegistryEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("registrationNotify")
public class RegistrationNotifyHandlerEntry implements RegistryEntry {
  @Autowired
  MpsPort mpsPort;

  @Autowired
  AddressBookPort uvpPort;

  @Autowired
  WorkflowPort workflowPort;

  @Override
  public Handler getObject() throws Exception {
    return new RegistrationNotifyUsecase(mpsPort, uvpPort, workflowPort);
  }

  @Override
  public Class<?> getObjectType() {
    return RegistrationNotifyUsecase.class;
  }

  @Override
  public Class<? extends Command> getCommandType() {
    return RegistrationNotifyCommand.class;
  }
}

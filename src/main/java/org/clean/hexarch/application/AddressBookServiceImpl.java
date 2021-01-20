package org.clean.hexarch.application;

import org.apache.commons.lang3.StringUtils;
import org.clean.hexarch.application.domain.service.RegistrationNotifyCommand;
import org.clean.hexarch.application.util.bus.CommandBus;
import org.clean.hexarch.util.exception.ComponentException;
import org.clean.hexarch.util.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
class AddressBookServiceImpl implements AddressBookService {
  @Autowired
  private CommandBus bus;

  @Override
  public void handle(RegistrationNotifyEvent event) {
    try {
      validate(event);

      bus.execute(new RegistrationNotifyCommand(event.getBan(), event.getContext()));
    } catch (ComponentException e) {
      handleInvalidEvent(event, e);
    }
  }

  private void validate(RegistrationNotifyEvent event) throws ValidationException {
    if (StringUtils.isEmpty(event.getBan())) {
      throw new ValidationException("Ban is missing");
    }
  }

  @Override
  public void handle(UnknownEvent event) {
    try {
      throw new ValidationException("Message type is missing or not supported");
    } catch (ComponentException e) {
      handleInvalidEvent(event, e);
    }
  }

  private void handleInvalidEvent(ApplicationEvent event, ComponentException e) {
    log.error(String.format("Invalid event: %s", event), e.getMessage());
  }
}

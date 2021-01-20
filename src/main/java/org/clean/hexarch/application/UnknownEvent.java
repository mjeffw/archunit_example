package org.clean.hexarch.application;

import java.util.Map;

public class UnknownEvent extends ApplicationEvent {
  public UnknownEvent(String ban, Map<String, Object> context) {
    super(ban, context);
  }

  @Override
  public void dispatch(AddressBookService service) {
    service.handle(this);
  }
}

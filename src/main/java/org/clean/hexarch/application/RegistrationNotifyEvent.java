package org.clean.hexarch.application;

import java.util.Map;

public class RegistrationNotifyEvent extends ApplicationEvent {
  public RegistrationNotifyEvent(String ban, Map<String, Object> context) {
    super(ban, context);
  }

  @Override
  public void dispatch(AddressBookService service) {
    service.handle(this);
  }

  public String getBan() {
    // TODO Auto-generated method stub
    return null;
  }

  public Map<String, Object> getContext() {
    // TODO Auto-generated method stub
    return null;
  }
}

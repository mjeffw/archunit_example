package org.clean.hexarch.adapter.restapi;

import java.util.Map;

import org.clean.hexarch.adapter.restapi.data.FlowMessage;
import org.clean.hexarch.application.AddressBookService;
import org.clean.hexarch.application.ApplicationEvent;
import org.clean.hexarch.application.RegistrationNotifyEvent;
import org.clean.hexarch.application.UnknownEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class RequestAdapter {
  @Autowired
  private AddressBookService service;

  public void handleWorkflowRequest(FlowMessage request) {
    ApplicationEvent event = createEvent(request);
    event.dispatch(service);
  }

  private ApplicationEvent createEvent(FlowMessage message) {
    Map<String, Object> context = ContextMapperUtil.toContext(message);
    RequestType type = getRequestType(message);
    switch (type) {
    case REGISTRATIONNOTIFY:
      return new RegistrationNotifyEvent(message.getBan(), context);

    default:
      return new UnknownEvent(message.getBan(), context);
    }
  }

  private RequestType getRequestType(FlowMessage message) {
    try {
      return RequestType.valueOf(message.getMessageType());
    } catch (Exception e) {
      throw new InternalProcessingException();
    }
  }
}
package org.clean.hexarch.application;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EventServiceRoutingTest {
  @Mock
  AddressBookService service;

  @Test
  void testRegistrationEvent() {
    ApplicationEvent event = new RegistrationNotifyEvent(null, null);
    event.dispatch(service);

    verify(service).handle((RegistrationNotifyEvent) event);
  }

  @Test
  void testUnknownEvent() {
    ApplicationEvent event = new UnknownEvent(null, null);
    event.dispatch(service);

    verify(service).handle((UnknownEvent) event);
  }
}

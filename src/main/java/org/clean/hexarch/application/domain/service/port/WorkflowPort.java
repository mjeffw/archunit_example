package org.clean.hexarch.application.domain.service.port;

import java.util.Map;

import org.clean.hexarch.application.domain.model.AddAddressBookResponse;

public interface WorkflowPort {
  void send(AddAddressBookResponse response, Map<String, Object> context);
}

package org.clean.hexarch.adapter.worflow;

import java.util.Map;

import org.clean.hexarch.application.domain.model.AddAddressBookResponse;
import org.clean.hexarch.application.domain.service.port.WorkflowPort;
import org.springframework.stereotype.Component;

@Component
public class WorkflowResponderImpl implements WorkflowPort {

  @Override
  public void send(AddAddressBookResponse response, Map<String, Object> context) {
    // TODO Auto-generated method stub

  }

}

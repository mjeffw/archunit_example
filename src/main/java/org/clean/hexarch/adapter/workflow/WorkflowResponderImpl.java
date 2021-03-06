package org.clean.hexarch.adapter.workflow;

import java.util.Map;

import org.clean.hexarch.application.domain.model.AddAddressBookResponse;
import org.clean.hexarch.application.domain.service.port.WorkflowPort;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class WorkflowResponderImpl implements WorkflowPort {

  @Override
  public void send(AddAddressBookResponse response, Map<String, Object> context) {
    try {
      log.debug(response.toString());
    } catch (Exception e) {
      throw new WorkflowCommunicationException();
    }
  }
}

package org.clean.hexarch.application.domain.service;

import java.util.Map;

import org.clean.hexarch.application.domain.model.Ban;
import org.clean.hexarch.application.util.bus.Command;

import lombok.Getter;

public class RegistrationNotifyCommand implements Command {
  @Getter
  private final Ban ban;

  @Getter
  private final Map<String, Object> context;

  public RegistrationNotifyCommand(String ban, Map<String, Object> context) {
    this.ban = new Ban(ban);
    this.context = context;
  }
}

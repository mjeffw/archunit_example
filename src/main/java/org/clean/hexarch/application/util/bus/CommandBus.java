package org.clean.hexarch.application.util.bus;

public interface CommandBus {
  void execute(Command command);
}

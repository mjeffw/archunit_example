package org.clean.hexarch.application.util.bus;

import org.springframework.beans.factory.annotation.Autowired;

class SynchronousCommandBus implements CommandBus {
  private HandlerRegistry registry;

  public SynchronousCommandBus(@Autowired HandlerRegistry registry) {
    this.registry = registry;
  }

  @Override
  public void execute(Command command) {
    registry.lookup(command).handle(command);
  }
}

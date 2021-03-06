package org.clean.hexarch.application.util.bus;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
class CommandBusFactory implements FactoryBean<CommandBus> {
  @Autowired
  private HandlerRegistry registry;

  @Override
  public CommandBus getObject() throws Exception {
    try {
      return new SynchronousCommandBus(registry);
    } catch (Exception e) {
      throw new IllegalStateException();
    }
  }

  @Override
  public Class<?> getObjectType() {
    return CommandBus.class;
  }

  @Override
  public boolean isSingleton() {
    return true;
  }
}

package org.clean.hexarch.application.util.bus;

import org.springframework.beans.factory.FactoryBean;

public interface RegistryEntry extends FactoryBean<Handler> {
  Class<? extends Command> getCommandType();
}

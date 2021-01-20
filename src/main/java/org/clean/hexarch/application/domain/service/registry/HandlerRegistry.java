package org.clean.hexarch.application.domain.service.registry;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.clean.hexarch.application.util.bus.Command;
import org.clean.hexarch.application.util.bus.Handler;
import org.clean.hexarch.application.util.bus.HandlerCreationException;
import org.clean.hexarch.application.util.bus.HandlerRegistry;
import org.clean.hexarch.application.util.bus.RegistryEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
class HandlerRegistryImpl implements HandlerRegistry {
  @Autowired
  @Qualifier("registrationNotify")
  private RegistryEntry registrationNotifyEntry;

  @Override
  public List<RegistryEntry> getAll() {
    return Arrays.asList(registrationNotifyEntry);
  }

  @Override
  public Handler lookup(Command command) {
    try {
      Optional<RegistryEntry> result = getAll().stream().filter(it -> it.getCommandType() == command.getClass())
          .findFirst();

      // TODO return the "invalid request" handler entry
      return result.orElse(null).getObject();
    } catch (Exception e) {
      throw new HandlerCreationException(e);
    }
  }
}
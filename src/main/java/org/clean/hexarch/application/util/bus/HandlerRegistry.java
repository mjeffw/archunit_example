package org.clean.hexarch.application.util.bus;

import java.util.List;

public interface HandlerRegistry {
  Handler lookup(Command command);

  List<RegistryEntry> getAll();
}

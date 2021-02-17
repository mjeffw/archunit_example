package org.clean.hexarch.application.util.bus;

import org.clean.hexarch.util.exception.ComponentException;

public class HandlerCreationException extends ComponentException {
  private static final long serialVersionUID = 1L;

  public HandlerCreationException(Exception e) {
    super(e);
  }
}

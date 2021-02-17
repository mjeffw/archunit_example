package org.clean.hexarch.application.util.bus;

import org.clean.hexarch.util.exception.ComponentException;

public class HandlerNotDefinedException extends ComponentException {
  private static final long serialVersionUID = 1L;

  public HandlerNotDefinedException(String message) {
    super(message);
  }
}

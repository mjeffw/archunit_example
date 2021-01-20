package org.clean.hexarch.application.util.bus;

public class HandlerNotDefinedException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public HandlerNotDefinedException(String message) {
    super(message);
  }
}

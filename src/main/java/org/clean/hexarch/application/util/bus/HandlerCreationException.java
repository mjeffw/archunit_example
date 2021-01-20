package org.clean.hexarch.application.util.bus;

public class HandlerCreationException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public HandlerCreationException(Exception e) {
    super(e);
  }
}

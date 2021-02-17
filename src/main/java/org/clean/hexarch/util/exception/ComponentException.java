package org.clean.hexarch.util.exception;

public class ComponentException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public ComponentException() {
  }

  public ComponentException(String message) {
    super(message);
  }

  public ComponentException(Throwable cause) {
    super(cause);
  }
}

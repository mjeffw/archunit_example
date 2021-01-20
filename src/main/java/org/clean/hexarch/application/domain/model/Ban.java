package org.clean.hexarch.application.domain.model;

public class Ban {
  private String value;

  public Ban(String value) {
    this.value = value;
  }

  public String asStringValue() {
    return value;
  }
}

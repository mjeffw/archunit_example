package org.clean.hexarch.application;

import java.util.Map;

import lombok.AccessLevel;
import lombok.Getter;

public abstract class ApplicationEvent {
  /**
   * Context is an opaque object used only for responding back to the caller. It
   * is needed when the response needs data from the original request for the
   * caller's own correlation. Do not use or depend upon any data in context.
   */
  @Getter(AccessLevel.PROTECTED)
  private final Map<String, Object> context;

  @Getter(AccessLevel.PROTECTED)
  private String ban;

  public ApplicationEvent(String ban, Map<String, Object> context) {
    this.ban = ban;
    this.context = context;
  }

  public abstract void dispatch(AddressBookService service);
}

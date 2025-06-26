package org.sopt.doggywalker.backendapi.domain.user.domain.model;

import lombok.Getter;

@Getter
public class User {

  private final Long id;
  private final String name;

  public User(String name) {
    this(null, name);
  }

  protected User(final Long id, final String name) {
    this.id = id;
    this.name = name;
  }

  public static User of(final String name) {
    return new User(name);
  }

  public static User of(final Long id, final String name) {
    return new User(id, name);
  }
}

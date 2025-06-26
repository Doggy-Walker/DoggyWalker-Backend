package org.sopt.doggywalker.backendapi.domain.user.application.dto.request;

public record CreateUserServiceRequest(
    String name
) {

  public static CreateUserServiceRequest of(final String name) {
    return new CreateUserServiceRequest(name);
  }
}

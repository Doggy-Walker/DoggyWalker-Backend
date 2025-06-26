package org.sopt.doggywalker.backendapi.domain.user.application.dto.response;

import org.sopt.doggywalker.backendapi.domain.user.domain.model.User;

public record CreateUserServiceResponse(
    String userName
) {

  public static CreateUserServiceResponse from(final User user) {
    return new CreateUserServiceResponse(user.getName());
  }
}

package org.sopt.doggywalker.backendapi.domain.user.application.dto.response;

import org.sopt.doggywalker.backendapi.domain.user.domain.model.User;

public record CreateUserServiceResponse(
    Long id,
    String userName,
    String loginId
) {

  public static CreateUserServiceResponse from(final User user) {
    return new CreateUserServiceResponse(user.getId(), user.getName(), user.getLoginId());
  }
}

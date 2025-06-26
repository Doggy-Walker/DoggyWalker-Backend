package org.sopt.doggywalker.backendapi.domain.user.api.dto.request;

import jakarta.validation.constraints.NotNull;
import org.sopt.doggywalker.backendapi.domain.user.application.dto.request.CreateUserServiceRequest;

public record CreateUserRequest(
    @NotNull(message = "이름은 필수값입니다.") String name,
    @NotNull(message = "숫자는 필수값입니다.") String number
    ) {

  public CreateUserServiceRequest toServiceRequest() {
    return CreateUserServiceRequest.of(name());
  }
}

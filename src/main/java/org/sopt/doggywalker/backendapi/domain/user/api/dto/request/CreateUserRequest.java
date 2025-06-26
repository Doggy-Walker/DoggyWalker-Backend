package org.sopt.doggywalker.backendapi.domain.user.api.dto.request;

import jakarta.validation.constraints.NotNull;
import org.sopt.doggywalker.backendapi.domain.user.application.dto.request.CreateUserServiceRequest;

public record CreateUserRequest(
    @NotNull String name
    ) {

  public CreateUserServiceRequest toServiceRequest() {
    return CreateUserServiceRequest.of(name());
  }
}

package org.sopt.doggywalker.backendapi.domain.user.api.dto.request;

import org.sopt.doggywalker.backendapi.domain.user.application.dto.request.CreateUserServiceRequest;

import jakarta.validation.constraints.NotNull;

public record CreateUserRequest(
	@NotNull(message = "이름은 필수값입니다.") String name,
	@NotNull(message = "로그인 아이디는 필수값입니다.") String loginId
) {

	public CreateUserServiceRequest toServiceRequest() {
		return CreateUserServiceRequest.of(loginId(), name());
	}
}

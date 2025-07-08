package org.sopt.doggywalker.backendapi.domain.user.api.dto.request;

import org.sopt.doggywalker.backendapi.domain.user.application.dto.request.CreateUserCommand;

import jakarta.validation.constraints.NotNull;

public record CreateUserRequestDto(
	@NotNull(message = "이름은 필수값입니다.") String name,
	@NotNull(message = "로그인 아이디는 필수값입니다.") String loginId
) {

	public CreateUserCommand toCommand() {
		return CreateUserCommand.of(name(), loginId());
	}
}

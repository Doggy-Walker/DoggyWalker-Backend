package org.sopt.pawkey.backendapi.domain.user.api.dto.response;

import org.sopt.pawkey.backendapi.domain.user.application.dto.response.CreateUserResult;

public record CreateUserResponseDto(
	Long id,
	String userName,
	String loginId
) {

	public static CreateUserResponseDto from(final CreateUserResult createUserResult) {
		return new CreateUserResponseDto(
			createUserResult.id(),
			createUserResult.userName(),
			createUserResult.loginId()
		);
	}
}

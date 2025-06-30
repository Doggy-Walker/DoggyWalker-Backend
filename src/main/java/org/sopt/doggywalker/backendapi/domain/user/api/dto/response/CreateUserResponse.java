package org.sopt.doggywalker.backendapi.domain.user.api.dto.response;

import org.sopt.doggywalker.backendapi.domain.user.application.dto.response.CreateUserServiceResponse;

public record CreateUserResponse(
	Long id,
	String userName,
	String loginId
) {

	public static CreateUserResponse from(final CreateUserServiceResponse userResponse) {
		return new CreateUserResponse(
			userResponse.id(),
			userResponse.userName(),
			userResponse.loginId()
		);
	}
}

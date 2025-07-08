package org.sopt.doggywalker.backendapi.domain.user.application.dto.response;

import org.sopt.doggywalker.backendapi.domain.user.domain.model.User;

public record CreateUserResult(
	Long id,
	String userName,
	String loginId
) {

	public static CreateUserResult from(final User user) {
		return new CreateUserResult(user.getId(), user.getName(), user.getLoginId());
	}
}

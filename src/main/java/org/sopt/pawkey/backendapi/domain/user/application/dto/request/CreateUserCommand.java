package org.sopt.pawkey.backendapi.domain.user.application.dto.request;

public record CreateUserCommand(
	String name,
	String loginId
) {

	public static CreateUserCommand of(final String name, final String loginId) {
		return new CreateUserCommand(name, loginId);
	}
}

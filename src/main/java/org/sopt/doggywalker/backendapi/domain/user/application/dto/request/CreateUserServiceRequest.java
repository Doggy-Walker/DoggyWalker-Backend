package org.sopt.doggywalker.backendapi.domain.user.application.dto.request;

public record CreateUserServiceRequest(
	String loginId,
	String name
) {

	public static CreateUserServiceRequest of(final String loginId, final String name) {
		return new CreateUserServiceRequest(loginId, name);
	}
}

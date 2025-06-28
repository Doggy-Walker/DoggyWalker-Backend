package org.sopt.doggywalker.backendapi.domain.user.application.dto.request;

public record CreateUserServiceRequest(
	String name,
	String loginId
) {

	public static CreateUserServiceRequest of(final String name, final String loginId) {
		return new CreateUserServiceRequest(name, loginId);
	}
}

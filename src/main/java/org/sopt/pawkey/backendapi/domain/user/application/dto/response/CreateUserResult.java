package org.sopt.pawkey.backendapi.domain.user.application.dto.response;

// public record CreateUserResult(
// 	Long id,
// 	String userName,
// 	String loginId
// ) {
//
// 	public static CreateUserResult from(final User user) {
// 		return new CreateUserResult(user.getUserId(), user.getName(), user.getUserId());
// 	}
// }

public record CreateUserResult(
	Long id,
	String userName,
	String loginId
) {

	// public static CreateUserResult from(final User user) {
	// 	return new CreateUserResult(user.getUserId(), user.getName(), user.getLoginId());
	// }
}

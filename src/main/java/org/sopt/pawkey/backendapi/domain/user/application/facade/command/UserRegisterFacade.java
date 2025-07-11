package org.sopt.pawkey.backendapi.domain.user.application.facade.command;

// import org.sopt.pawkey.backendapi.domain.user.application.dto.request.CreateUserCommand;
// import org.sopt.pawkey.backendapi.domain.user.application.dto.response.CreateUserResult;

import org.sopt.pawkey.backendapi.domain.user.application.service.UserService;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserRegisterFacade {

	private final UserService userService;

	// public CreateUserResult execute(CreateUserCommand request) {
	// 	User user = userService.createUser(request);
	//
	// 	return CreateUserResult.from(user);
	// }
}

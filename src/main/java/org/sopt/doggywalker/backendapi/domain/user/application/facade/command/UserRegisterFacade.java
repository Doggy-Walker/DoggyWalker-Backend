package org.sopt.doggywalker.backendapi.domain.user.application.facade.command;

import org.sopt.doggywalker.backendapi.domain.user.application.dto.request.CreateUserServiceRequest;
import org.sopt.doggywalker.backendapi.domain.user.application.dto.response.CreateUserServiceResponse;
import org.sopt.doggywalker.backendapi.domain.user.application.service.UserService;
import org.sopt.doggywalker.backendapi.domain.user.domain.model.User;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserRegisterFacade {

	private final UserService userService;

	public CreateUserServiceResponse execute(CreateUserServiceRequest request) {
		User user = userService.createUser(request);

		return CreateUserServiceResponse.from(user);
	}
}

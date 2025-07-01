package org.sopt.doggywalker.backendapi.domain.user.api.controller;

import org.sopt.doggywalker.backendapi.domain.user.api.dto.request.CreateUserRequest;
import org.sopt.doggywalker.backendapi.domain.user.api.dto.response.CreateUserResponse;
import org.sopt.doggywalker.backendapi.domain.user.application.facade.command.UserRegisterFacade;
import org.sopt.doggywalker.backendapi.global.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

	private final UserRegisterFacade userRegisterFacade;

	@PostMapping
	public ResponseEntity<ApiResponse<CreateUserResponse>> create(
		@RequestBody @Valid CreateUserRequest createUserRequest) {

		final CreateUserResponse response = CreateUserResponse.from(
			userRegisterFacade.execute(createUserRequest.toServiceRequest()));

		return ResponseEntity.ok(ApiResponse.success(response));
	}
}

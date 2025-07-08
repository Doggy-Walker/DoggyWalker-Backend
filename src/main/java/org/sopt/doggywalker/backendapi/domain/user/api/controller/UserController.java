package org.sopt.doggywalker.backendapi.domain.user.api.controller;

import org.sopt.doggywalker.backendapi.domain.user.api.dto.request.CreateUserRequestDto;
import org.sopt.doggywalker.backendapi.domain.user.api.dto.response.CreateUserResponseDto;
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
	public ResponseEntity<ApiResponse<CreateUserResponseDto>> create(
		@RequestBody @Valid CreateUserRequestDto createUserRequestDto) {

		final CreateUserResponseDto response = CreateUserResponseDto.from(
			userRegisterFacade.execute(createUserRequestDto.toCommand()));

		return ResponseEntity.ok(ApiResponse.success(response));
	}
}

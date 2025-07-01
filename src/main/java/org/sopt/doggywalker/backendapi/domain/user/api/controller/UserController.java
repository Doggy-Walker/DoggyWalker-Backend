package org.sopt.doggywalker.backendapi.domain.user.api.controller;

import org.sopt.doggywalker.backendapi.domain.user.api.dto.request.CreateUserRequest;
import org.sopt.doggywalker.backendapi.domain.user.api.dto.response.CreateUserResponse;
import org.sopt.doggywalker.backendapi.domain.user.application.facade.UserFacade;
import org.sopt.doggywalker.backendapi.global.exception.ErrorCode;
import org.sopt.doggywalker.backendapi.global.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

	private final UserFacade userFacade;

	@Operation(summary = "유저 생성", description = "회원가입 또는 유저 등록 API입니다.", tags = {"User"})
	@ApiResponses({
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "유저 생성 성공", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CreateUserResponse.class))),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "서버 내부 오류", content = @Content)
	})
	@PostMapping
	public ResponseEntity<ApiResponse<CreateUserResponse>> create(
		@RequestBody @Valid CreateUserRequest createUserRequest) {

		final CreateUserResponse response = CreateUserResponse.from(
			userFacade.register(createUserRequest.toServiceRequest()));

		return ResponseEntity.ok(ApiResponse.success(response));
	}
}

package org.sopt.pawkey.backendapi.domain.user.api.controller;

import org.sopt.pawkey.backendapi.domain.user.application.facade.command.UserRegisterFacade;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

	private final UserRegisterFacade userRegisterFacade;

	// @Operation(summary = "유저 생성", description = "회원가입 또는 유저 등록 API입니다.", tags = {"User"})
	// @ApiResponses({
	// 	@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "유저 생성 성공"),
	// 	@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content(mediaType = "application/json")),
	// 	@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "서버 내부 오류", content = @Content(mediaType = "application/json"))})
	// @PostMapping
	// public ResponseEntity<ApiResponse<CreateUserResponseDto>> create(
	// 	@RequestBody @Valid CreateUserRequestDto createUserRequestDto) {
	//
	// 	final CreateUserResponseDto response = CreateUserResponseDto.from(
	// 		userRegisterFacade.execute(createUserRequestDto.toCommand()));
	//
	// 	return ResponseEntity.ok(ApiResponse.success(response));
	// }
}

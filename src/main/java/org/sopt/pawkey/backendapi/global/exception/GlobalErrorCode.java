package org.sopt.pawkey.backendapi.global.exception;

import org.springframework.http.HttpStatus;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public enum GlobalErrorCode implements ErrorCode {

	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "G50001", "서버 내부 오류가 발생했습니다"),
	MISSING_REQUIRED_HEADER(HttpStatus.BAD_REQUEST, "G40001", "필수 헤더가 누락되었습니다.");

	private final HttpStatus status;
	private final String code;
	private final String message;

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public HttpStatus getStatus() {
		return status;
	}
}

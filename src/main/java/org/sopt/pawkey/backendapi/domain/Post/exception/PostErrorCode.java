package org.sopt.pawkey.backendapi.domain.post.exception;

import org.sopt.pawkey.backendapi.global.exception.ErrorCode;
import org.springframework.http.HttpStatus;

public enum PostErrorCode implements ErrorCode {

	POST_NOT_FOUND("P40401", "존재하지 않는 게시글입니다.", HttpStatus.NOT_FOUND);

	private final String code;
	private final String message;
	private final HttpStatus status;

	PostErrorCode(final String code, final String message, final HttpStatus status) {
		this.code = code;
		this.message = message;
		this.status = status;
	}

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

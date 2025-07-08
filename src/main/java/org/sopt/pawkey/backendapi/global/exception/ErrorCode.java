package org.sopt.pawkey.backendapi.global.exception;

import org.springframework.http.HttpStatus;

public interface ErrorCode {

	String getCode();

	String getMessage();

	HttpStatus getStatus();
}

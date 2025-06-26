package org.sopt.doggywalker.backendapi.domain.user.exception;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.sopt.doggywalker.backendapi.global.exception.ErrorCode;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public enum UserErrorCode implements ErrorCode {

  USER_DUPLICATE_LOGIN_ID(HttpStatus.CONFLICT, "G40900", "중복된 로그인 아이디입니다.");

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

package org.sopt.doggywalker.backendapi.global.exception;

import org.springframework.http.HttpStatus;

public enum GlobalErrorCode implements ErrorCode {

  INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "G50001", "서버 내부 오류가 발생했습니다");

  private final HttpStatus status;
  private final String code;
  private final String message;

  GlobalErrorCode(HttpStatus status, String code, String message) {
    this.status = status;
    this.code = code;
    this.message = message;
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

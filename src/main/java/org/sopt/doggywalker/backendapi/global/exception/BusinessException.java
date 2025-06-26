package org.sopt.doggywalker.backendapi.global.exception;

import lombok.Getter;

@Getter
public abstract class BusinessException extends RuntimeException {

  private final ErrorCode errorCode;

  protected BusinessException(ErrorCode errorCode) {
    super(errorCode.getMessage());
    this.errorCode = errorCode;
  }
}


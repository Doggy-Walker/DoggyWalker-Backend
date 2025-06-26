package org.sopt.doggywalker.backendapi.global.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * 전역 응답 코드 HTTP·프레임워크 예외 대응
 */
@Getter
public enum ResponseCode {
  SUCCESS(HttpStatus.OK, "S000", "요청 처리 성공"),
  CREATED(HttpStatus.CREATED, "S001", "리소스 생성 완료"),

  BAD_REQUEST(HttpStatus.BAD_REQUEST, "E400", "잘못된 요청"),
  UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "E401", "인증 필요"),
  FORBIDDEN(HttpStatus.FORBIDDEN, "E403", "권한 없음"),
  NOT_FOUND(HttpStatus.NOT_FOUND, "E404", "리소스를 찾을 수 없음"),
  CONFLICT(HttpStatus.CONFLICT, "E409", "데이터 충돌"),
  INTERNAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "E500", "서버 내부 오류");


  private final HttpStatus status;
  private final String code;
  private final String message;

  ResponseCode(HttpStatus status, String code, String message) {
    this.status = status;
    this.code = code;
    this.message = message;
  }
}

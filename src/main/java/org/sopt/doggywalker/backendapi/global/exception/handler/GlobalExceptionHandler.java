package org.sopt.doggywalker.backendapi.global.exception.handler;

import jakarta.validation.ConstraintViolationException;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.sopt.doggywalker.backendapi.global.exception.BusinessException;
import org.sopt.doggywalker.backendapi.global.exception.GlobalErrorCode;
import org.sopt.doggywalker.backendapi.global.response.ApiResponse;
import org.sopt.doggywalker.backendapi.global.response.ResponseCode;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(BusinessException.class)
  public ApiResponse<Void> handleBusinessException(BusinessException ex) {
    var ec = ex.getErrorCode();
    log.warn("BusinessException: code={}, message={}", ec.getCode(), ex.getMessage());

    return ApiResponse.error(ec.getCode(), ec.getMessage());
  }

  /**
   * DTO 유효성 검증 실패 처리 (@Valid, @Validated)
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ApiResponse<Void> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
    String messages = ex.getBindingResult().getFieldErrors().stream()
        .map(FieldError::getDefaultMessage)
        .collect(Collectors.joining("; "));

    log.warn("Validation failed: {}", messages);

    return ApiResponse.error(ResponseCode.BAD_REQUEST.getCode(), messages);
  }

  /**
   * 요청 본문(JSON 파싱 오류 처리)
   */
  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ApiResponse<Void> handleNotReadable(HttpMessageNotReadableException ex) {
    log.warn("JSON parse error: {}", ex.getMessage());

    return ApiResponse.error(ResponseCode.BAD_REQUEST.getCode(), "잘못된 요청 본문입니다");
  }

  /**
   * MissingServletRequestParameterException 등 바인딩 오류 처리
   */
  @ExceptionHandler(BindException.class)
  public ApiResponse<Void> handleBindException(BindException ex) {
    String messages = ex.getBindingResult().getFieldErrors().stream()
        .map(e -> e.getField() + ": " + e.getDefaultMessage())
        .collect(Collectors.joining("; "));
    log.warn("Bind error: {}", messages);

    return ApiResponse.error(ResponseCode.BAD_REQUEST.getCode(), messages);
  }

  /**
   * 제약조건 위반 처리(@Validated on path, request param 등)
   */
  @ExceptionHandler(ConstraintViolationException.class)
  public ApiResponse<Void> handleConstraintViolation(ConstraintViolationException ex) {
    String messages = ex.getConstraintViolations().stream()
        .map(v -> v.getMessage())
        .collect(Collectors.joining("; "));
    log.warn("Constraint violation: {}", messages);
    
    return ApiResponse.error(ResponseCode.BAD_REQUEST.getCode(), messages);
  }

  /**
   * 지원하지 않는 HTTP 메서드 처리
   */
  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  public ApiResponse<Void> handleMethodNotSupported(HttpRequestMethodNotSupportedException ex) {
    String msg = String.format("지원하지 않는 메서드입니다. 허용된 메서드: %s",
        String.join(", ", ex.getSupportedHttpMethods().stream()
            .map(HttpMethod::name).toList()));
    log.warn("Method not supported: {}", ex.getMethod());

    return ApiResponse.error(ResponseCode.BAD_REQUEST.getCode(), msg);
  }

  /**
   * 지원하지 않는 미디어 타입 처리
   */
  @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
  public ApiResponse<Void> handleMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex) {
    String msg = String.format("지원하지 않는 미디어 타입입니다. 허용된 타입: %s",
        String.join(", ", ex.getSupportedMediaTypes().stream()
            .map(Object::toString).toList()));
    log.warn("Media type not supported: {}", ex.getContentType());

    return ApiResponse.error(ResponseCode.BAD_REQUEST.getCode(), msg);
  }

  /**
   * 핸들러 미발견 처리 (404)
   */
  @ExceptionHandler(NoHandlerFoundException.class)
  public ApiResponse<Void> handleNoHandlerFound(NoHandlerFoundException ex) {
    log.warn("No handler found: {}", ex.getRequestURL());

    return ApiResponse.error(ResponseCode.NOT_FOUND.getCode(), "요청 URL을 찾을 수 없습니다");
  }

  /**
   * 그 외 모든 예외 처리
   */
  @ExceptionHandler(Exception.class)
  public ApiResponse<Void> handleGenericException(Exception ex, WebRequest req) {
    log.error("Unexpected error", ex);

    return ApiResponse.error(GlobalErrorCode.INTERNAL_SERVER_ERROR.getCode(),
        GlobalErrorCode.INTERNAL_SERVER_ERROR.getMessage());
  }
}

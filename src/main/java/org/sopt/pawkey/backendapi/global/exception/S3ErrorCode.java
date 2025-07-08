package org.sopt.pawkey.backendapi.global.exception;

import org.springframework.http.HttpStatus;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public enum S3ErrorCode implements ErrorCode{
	EMPTY_FILE_EXCEPTION(HttpStatus.BAD_REQUEST, "S3_40001", "업로드할 파일이 비어있습니다."),
	NO_FILE_EXTENSION(HttpStatus.BAD_REQUEST, "S3_40002", "파일 확장자가 없습니다."),
	INVALID_FILE_EXTENSION(HttpStatus.BAD_REQUEST, "S3_40003", "지원하지 않는 파일 확장자입니다."),
	IO_EXCEPTION_ON_IMAGE_UPLOAD(HttpStatus.INTERNAL_SERVER_ERROR, "S3_50001", "이미지 업로드 중 I/O 예외가 발생했습니다."),
	PUT_OBJECT_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "S3_50002", "S3에 객체를 업로드하는 중 오류가 발생했습니다."),
	IO_EXCEPTION_ON_IMAGE_DELETE(HttpStatus.INTERNAL_SERVER_ERROR, "S3_50003", "이미지 삭제 중 I/O 예외가 발생했습니다."),
	TOO_MANY_FILES(HttpStatus.BAD_REQUEST, "S3_40004", "최대 허용 파일 수를 초과했습니다.");

	private final HttpStatus status;
	private final String code;
	private final String message;

	@Override
	public HttpStatus getStatus() {
		return status;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}
}

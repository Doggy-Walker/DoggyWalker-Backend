package org.sopt.pawkey.backendapi.global.exception;

public class S3BusinessException extends BusinessException  {
	public S3BusinessException(ErrorCode errorCode) {
		super(errorCode);
	}
}

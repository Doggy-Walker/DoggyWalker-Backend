package org.sopt.pawkey.backendapi.domain.user.exception;

import org.sopt.pawkey.backendapi.global.exception.BusinessException;
import org.sopt.pawkey.backendapi.global.exception.ErrorCode;

public class UserBusinessException extends BusinessException {
	public UserBusinessException(ErrorCode errorCode) {
		super(errorCode);
	}
}

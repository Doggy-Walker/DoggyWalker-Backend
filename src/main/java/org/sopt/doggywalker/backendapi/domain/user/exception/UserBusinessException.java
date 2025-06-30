package org.sopt.doggywalker.backendapi.domain.user.exception;

import org.sopt.doggywalker.backendapi.global.exception.BusinessException;
import org.sopt.doggywalker.backendapi.global.exception.ErrorCode;

public class UserBusinessException extends BusinessException {
	public UserBusinessException(ErrorCode errorCode) {
		super(errorCode);
	}
}

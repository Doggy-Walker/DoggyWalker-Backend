package org.sopt.pawkey.backendapi.domain.post.exception;

import org.sopt.pawkey.backendapi.global.exception.BusinessException;
import org.sopt.pawkey.backendapi.global.exception.ErrorCode;

public class PostLikeBusinessException extends BusinessException {
	public PostLikeBusinessException(final PostLikeErrorCode errorCode) {
		super(errorCode);
	}
}
package org.sopt.pawkey.backendapi.domain.user.application.service;

import org.sopt.pawkey.backendapi.domain.user.infra.persistence.entity.UserEntity;

public interface UserService {
	UserEntity getByUserId(Long userId);

	UserEntity findById(Long userId);
}

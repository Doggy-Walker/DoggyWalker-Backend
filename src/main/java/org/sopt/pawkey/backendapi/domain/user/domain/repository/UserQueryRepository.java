package org.sopt.pawkey.backendapi.domain.user.domain.repository;

import java.util.Optional;

import org.sopt.pawkey.backendapi.domain.user.infra.persistence.entity.UserEntity;

public interface UserQueryRepository {

	Optional<UserEntity> getUserByUserId(Long userId);
}



package org.sopt.pawkey.backendapi.domain.user.domain.repository;

import java.util.Optional;

import org.sopt.pawkey.backendapi.domain.user.infra.persistence.entity.UserEntity;

public interface UserRepository {

	UserEntity save(final UserEntity user);

	boolean existsByLoginId(String loginId);

	void deleteAllInBatch();

	Optional<UserEntity> findById(Long id);
}

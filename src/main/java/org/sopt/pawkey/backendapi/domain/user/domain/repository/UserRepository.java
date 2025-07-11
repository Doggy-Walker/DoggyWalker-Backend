package org.sopt.pawkey.backendapi.domain.user.domain.repository;

import java.util.Optional;

import org.sopt.pawkey.backendapi.domain.user.domain.model.User;

public interface UserRepository {

	User save(User user);

	boolean existsByLoginId(String loginId);

	void deleteAllInBatch();

	Optional<User> findById(Long id);
}

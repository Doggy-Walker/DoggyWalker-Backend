package org.sopt.pawkey.backendapi.domain.user.domain.repository;

import org.sopt.pawkey.backendapi.domain.user.domain.model.User;

public interface UserRepository {

	User save(User user);

	boolean existsByLoginId(String loginId);

	void deleteAllInBatch();
}

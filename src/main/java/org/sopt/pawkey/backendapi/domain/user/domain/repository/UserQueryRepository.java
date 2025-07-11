package org.sopt.pawkey.backendapi.domain.user.domain.repository;

import java.util.List;
import java.util.Optional;

import org.sopt.pawkey.backendapi.domain.user.domain.model.User;

public interface UserQueryRepository {
	
	Optional<User> getUserByUserId(Long userId);
}



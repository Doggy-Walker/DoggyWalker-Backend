package org.sopt.pawkey.backendapi.domain.user.application.service;

import org.sopt.pawkey.backendapi.domain.user.domain.model.User;

public interface UserService {
	User getByUserId(Long userId);

	User findById(Long userId);

	//User createUser(final CreateUserCommand request);
}

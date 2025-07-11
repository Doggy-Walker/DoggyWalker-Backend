package org.sopt.pawkey.backendapi.domain.user.application.service;

import org.sopt.pawkey.backendapi.domain.user.application.dto.request.CreateUserCommand;
import org.sopt.pawkey.backendapi.domain.user.domain.model.User;

public interface UserService {

	User createUser(final CreateUserCommand request);

	User getByUserId(final Long userId);
}

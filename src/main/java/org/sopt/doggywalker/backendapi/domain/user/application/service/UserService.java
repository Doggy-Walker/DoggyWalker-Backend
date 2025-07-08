package org.sopt.doggywalker.backendapi.domain.user.application.service;

import org.sopt.doggywalker.backendapi.domain.user.application.dto.request.CreateUserCommand;
import org.sopt.doggywalker.backendapi.domain.user.domain.model.User;

public interface UserService {

	User createUser(final CreateUserCommand request);
}

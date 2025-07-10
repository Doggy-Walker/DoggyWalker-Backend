package org.sopt.pawkey.backendapi.domain.user.application.service;

import org.sopt.pawkey.backendapi.domain.user.application.dto.request.CreateUserCommand;
import org.sopt.pawkey.backendapi.domain.user.domain.model.User;
import org.sopt.pawkey.backendapi.domain.user.domain.repository.UserQueryRepository;
import org.sopt.pawkey.backendapi.domain.user.domain.repository.UserRepository;
import org.sopt.pawkey.backendapi.domain.user.exception.UserBusinessException;
import org.sopt.pawkey.backendapi.domain.user.exception.UserErrorCode;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final UserQueryRepository userQueryRepository;

	/**
	 * @param request User 생성 request
	 * @return user 도메인 모델
	 */
	@Override
	public User createUser(final CreateUserCommand request) {
		final String loginId = request.loginId();
		final String name = request.name();

		if (userRepository.existsByLoginId(loginId)) {
			throw new UserBusinessException(UserErrorCode.USER_DUPLICATE_LOGIN_ID);
		}

		User user = User.builder()
			.loginId(loginId)
			.name(name)
			.build();

		return userRepository.save(user);
	}

	@Override
	public User getByUserId(Long userId) {
		return userQueryRepository.getUserByUserId(userId);
	}
}

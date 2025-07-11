package org.sopt.pawkey.backendapi.domain.user.application.service;

import org.sopt.pawkey.backendapi.domain.user.application.dto.request.CreateUserCommand;
import org.sopt.pawkey.backendapi.domain.user.domain.model.User;
import org.sopt.pawkey.backendapi.domain.user.domain.repository.UserRepository;
import org.sopt.pawkey.backendapi.domain.user.exception.UserBusinessException;
import org.sopt.pawkey.backendapi.domain.user.exception.UserErrorCode;
import org.sopt.pawkey.backendapi.domain.user.infra.mapper.UserMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final UserMapper userMapper;

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

		//User user = User.createUser(loginId, name);

		return null;
	}

	public User findById(final Long id) {
		return userRepository.findById(id)
			.orElseThrow(() -> new UserBusinessException(UserErrorCode.USER_NOT_FOUND));
	}
}

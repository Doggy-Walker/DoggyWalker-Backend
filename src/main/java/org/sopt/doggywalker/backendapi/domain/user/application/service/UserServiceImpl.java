package org.sopt.doggywalker.backendapi.domain.user.application.service;

import org.sopt.doggywalker.backendapi.domain.user.application.dto.request.CreateUserServiceRequest;
import org.sopt.doggywalker.backendapi.domain.user.domain.model.User;
import org.sopt.doggywalker.backendapi.domain.user.domain.repository.UserRepository;
import org.sopt.doggywalker.backendapi.domain.user.exception.UserErrorCode;
import org.sopt.doggywalker.backendapi.global.exception.BusinessException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	/**
	 * @param request User 생성 request
	 * @return user 도메인 모델
	 */
	@Override
	public User createUser(final CreateUserServiceRequest request) {
		final String loginId = request.loginId();
		final String name = request.name();

		if (userRepository.existsByLoginId(loginId)) {
			throw new BusinessException(UserErrorCode.USER_DUPLICATE_LOGIN_ID);
		}

		User user = User.of(loginId, name);

		return userRepository.save(user);
	}
}

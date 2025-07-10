package org.sopt.pawkey.backendapi.domain.user.infra.persistence;

import org.sopt.pawkey.backendapi.domain.user.domain.model.User;
import org.sopt.pawkey.backendapi.domain.user.domain.repository.UserRepository;
import org.sopt.pawkey.backendapi.domain.user.infra.mapper.UserMapper;
import org.sopt.pawkey.backendapi.domain.user.infra.persistence.entity.UserEntity;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

	private final SpringDataUserRepository springDataUserRepository;
	private final UserMapper userMapper;

	@Override
	public User save(final User user) {
		UserEntity entity = userMapper.toEntity(user);
		UserEntity saved = springDataUserRepository.save(entity);

		return userMapper.toDomain(saved);
	}

	@Override
	public boolean existsByLoginId(final String loginId) {
		return false;
		// return springDataUserRepository.existsByLoginId(loginId);
	}

	@Override
	public void deleteAllInBatch() {
		springDataUserRepository.deleteAllInBatch();
	}
}

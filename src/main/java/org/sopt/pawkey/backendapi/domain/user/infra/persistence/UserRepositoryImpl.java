package org.sopt.pawkey.backendapi.domain.user.infra.persistence;

import java.util.Optional;

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

	@Override
	public User save(final User user) {
		UserEntity entity = UserMapper.toEntity(user);
		UserEntity saved = springDataUserRepository.save(entity);

		return UserMapper.toDomain(saved);
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

	@Override
	public Optional<User> findById(Long id) {
		return springDataUserRepository.findById(id).map(UserMapper::toDomain);
	}
}

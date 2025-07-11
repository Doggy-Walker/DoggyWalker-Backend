package org.sopt.pawkey.backendapi.domain.user.infra.persistence;

import java.util.List;
import java.util.Optional;

import org.sopt.pawkey.backendapi.domain.user.domain.model.User;
import org.sopt.pawkey.backendapi.domain.user.domain.repository.UserQueryRepository;
import org.sopt.pawkey.backendapi.domain.user.infra.mapper.UserMapper;
import org.sopt.pawkey.backendapi.domain.user.infra.persistence.entity.QUserEntity;
import org.sopt.pawkey.backendapi.domain.user.infra.persistence.entity.UserEntity;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserQueryRepositoryImpl implements UserQueryRepository {

	private final JPAQueryFactory jpaQueryFactory;
	private final UserMapper userMapper;

	@Override
	public Optional<User> getUserByUserId(Long userId) {
		QUserEntity userEntity = QUserEntity.userEntity;

		UserEntity found = jpaQueryFactory
			.selectFrom(userEntity)
			.where(userEntity.userId.eq(userId))
			.fetchOne();

		return Optional.ofNullable(found)
			.map(UserMapper::toDomain);
	}
}

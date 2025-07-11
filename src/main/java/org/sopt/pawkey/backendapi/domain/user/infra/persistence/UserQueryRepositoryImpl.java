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
	public List<User> getUsers() {
		QUserEntity userEntity = QUserEntity.userEntity;

		List<UserEntity> userEntities = jpaQueryFactory
			.selectFrom(userEntity)
			.orderBy(userEntity.userId.desc())
			.fetch();

		return userEntities.stream()
			.map(userMapper::toDomain)
			.toList();
	}

	@Override
	public List<User> getUsersByNameLike(String name) {
		QUserEntity userEntity = QUserEntity.userEntity;

		List<UserEntity> userEntities = jpaQueryFactory
			.selectFrom(userEntity)
			.where(userEntity.name.like("%" + name + "%"))
			.orderBy(userEntity.userId.desc())
			.fetch();

		return userEntities.stream()
			.map(userMapper::toDomain)
			.toList();
	}

	@Override
	public Optional<User> getUserByUserId(Long userId) {
		QUserEntity userEntity = QUserEntity.userEntity;

		UserEntity found = jpaQueryFactory
			.selectFrom(userEntity)
			.where(userEntity.userId.eq(userId))
			.fetchOne();

		return Optional.ofNullable(found)
			.map(userMapper::toDomain);
	}
}

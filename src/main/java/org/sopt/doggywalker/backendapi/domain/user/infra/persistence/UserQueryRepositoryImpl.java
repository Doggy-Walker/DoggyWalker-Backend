package org.sopt.doggywalker.backendapi.domain.user.infra.persistence;

import java.util.List;

import org.sopt.doggywalker.backendapi.domain.user.domain.model.User;
import org.sopt.doggywalker.backendapi.domain.user.domain.repository.UserQueryRepository;
import org.sopt.doggywalker.backendapi.domain.user.infra.mapper.UserMapper;
import org.sopt.doggywalker.backendapi.domain.user.infra.persistence.entity.QUserEntity;
import org.sopt.doggywalker.backendapi.domain.user.infra.persistence.entity.UserEntity;
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
			.orderBy(userEntity.id.desc())
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
			.orderBy(userEntity.id.desc())
			.fetch();

		return userEntities.stream()
			.map(userMapper::toDomain)
			.toList();
	}
}

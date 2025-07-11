package org.sopt.pawkey.backendapi.domain.user.infra.persistence;

import java.util.Optional;

import org.sopt.pawkey.backendapi.domain.user.domain.repository.UserQueryRepository;
import org.sopt.pawkey.backendapi.domain.user.infra.persistence.entity.QUserEntity;
import org.sopt.pawkey.backendapi.domain.user.infra.persistence.entity.UserEntity;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserQueryRepositoryImpl implements UserQueryRepository {

	private final JPAQueryFactory jpaQueryFactory;

	@Override
	public Optional<UserEntity> getUserByUserId(Long userId) {
		QUserEntity userEntity = QUserEntity.userEntity;

		return Optional.ofNullable(jpaQueryFactory
			.selectFrom(userEntity)
			.where(userEntity.userId.eq(userId))
			.fetchOne());

	}
}

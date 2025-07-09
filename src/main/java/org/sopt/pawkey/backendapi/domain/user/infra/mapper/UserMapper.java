package org.sopt.pawkey.backendapi.domain.user.infra.mapper;

import org.sopt.pawkey.backendapi.domain.user.domain.model.User;
import org.sopt.pawkey.backendapi.domain.user.infra.persistence.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
	/**
	 * 데이터베이스 인프라와 통신하기 위한 객체로 변경
	 * @param domain 유저 도메인 모델
	 * @return 유저 엔티티
	 */
	public UserEntity toEntity(User domain) {

		return UserEntity.createEntity(domain.getName(), domain.getLoginId());
	}

	/**
	 * 데이터베이스 엔티티를 도메인 로직에서 사용하기 위한 도메인 모델로 변경
	 * @param entity 유저 엔티티
	 * @return 유저 도메인 모델
	 */
	public User toDomain(UserEntity entity) {

		return User.createUser(entity.getUserId(), entity.getLoginId(), entity.getName());
	}
}

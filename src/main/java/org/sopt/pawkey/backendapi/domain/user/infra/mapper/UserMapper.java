package org.sopt.pawkey.backendapi.domain.user.infra.mapper;

import org.sopt.pawkey.backendapi.domain.user.domain.model.User;
import org.sopt.pawkey.backendapi.domain.user.infra.persistence.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

	public static User toDomain(UserEntity entity) {
		if (entity == null) return null;

		return new User(
			entity.getUserId(),
			entity.getName(),
			entity.getGender(),
			entity.getAge(),
			RegionMapper.toDomain(entity.getRegion()),  // 연관 객체도 Mapper로
			entity.getLoginId()
		);
	}

	public static UserEntity toEntity(User user) {
		if (user == null) return null;

		return UserEntity.builder()
			.userId(user.getUserId())                     // ← 수정
			.name(user.getName())
			.gender(user.getGender())                     // ← 수정
			.age(user.getAge())
			.region(RegionMapper.toEntity(user.getRegion()))
			.loginId(user.getLoginId())
			.build();
	}
}

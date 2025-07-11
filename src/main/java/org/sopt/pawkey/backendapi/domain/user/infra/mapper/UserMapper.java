package org.sopt.pawkey.backendapi.domain.user.infra.mapper;

import org.sopt.pawkey.backendapi.domain.region.infra.mapper.RegionMapper;
import org.sopt.pawkey.backendapi.domain.user.domain.model.User;
import org.sopt.pawkey.backendapi.domain.user.infra.persistence.entity.UserEntity;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserMapper {
	public static User toDomain(UserEntity entity) {
		if (entity == null)
			return null;

		return new User(
			entity.getUserId(),
			entity.getLoginId(),
			entity.getName(),
			entity.getGender(),
			entity.getAge(),
			RegionMapper.toDomain(entity.getRegion())  // 연관 객체 매핑
		);
	}

	public static UserEntity toEntity(User user) {
		if (user == null)
			return null;

		return UserEntity.builder()
			.userId(user.getId())
			.loginId(user.getLoginId())
			.name(user.getName())
			.gender(user.getGender())
			.age(user.getAge())
			.region(RegionMapper.toEntity(user.getRegion()))
			.build();
	}
}

package org.sopt.pawkey.backendapi.domain.user.domain.model;

import org.sopt.pawkey.backendapi.domain.region.infra.persistence.entity.RegionEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {

	private final Long userId;
	private final String name;
	private final String gender;
	private final Integer age;
	private final RegionEntity region;

	public static User createUser(final Long id, final String name, final String gender,
		final Integer age, final RegionEntity region) {
		return new User(id, name, gender, age, region);
	}
}

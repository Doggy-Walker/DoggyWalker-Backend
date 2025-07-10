package org.sopt.pawkey.backendapi.domain.user.domain.model;

import org.sopt.pawkey.backendapi.domain.region.infra.persistence.entity.RegionEntity;

import lombok.Getter;

@Getter
public class User {

	private final Long userId;
	private final String name;
	private final String gender;
	private final Integer age;
	private final RegionEntity region;

	protected User(final Long userId, final String name, final String gender, final Integer age,
		final RegionEntity region) {
		this.userId = userId;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.region = region;
	}

	public static User createUser(final Long id, final String name, final String gender,
		final Integer age, final RegionEntity region) {
		return new User(id, name, gender, age, region);
	}
}

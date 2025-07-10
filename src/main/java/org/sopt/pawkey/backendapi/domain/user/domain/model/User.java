package org.sopt.pawkey.backendapi.domain.user.domain.model;

import lombok.Getter;

@Getter
public class User {

	private final Long userId;
	private final String name;
	private final String gender;
	private final Integer age;

	protected User(final Long userId, final String name, final String gender, final Integer age) {
		this.userId = userId;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public static User createUser(final Long id, final String name, final String gender,
		final Integer age) {
		return new User(id, name, gender, age);
	}
}

package org.sopt.doggywalker.backendapi.domain.user.domain.model;

import lombok.Getter;

@Getter
public class User {

	private final Long id;
	private final String loginId;
	private final String name;

	protected User(final Long id, final String loginId, final String name) {
		this.id = id;
		this.loginId = loginId;
		this.name = name;
	}

	public static User createUser(final String loginId, final String name) {
		return User.createUser(null, loginId, name);
	}

	public static User createUser(final Long id, final String loginId, final String name) {
		return new User(id, loginId, name);
	}
}

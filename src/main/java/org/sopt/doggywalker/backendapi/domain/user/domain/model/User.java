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

	public static User of(final String loginId, final String name) {
		return User.of(null, loginId, name);
	}

	public static User of(final Long id, final String loginId, final String name) {
		return new User(id, loginId, name);
	}
}

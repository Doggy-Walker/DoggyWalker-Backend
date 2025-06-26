package org.sopt.doggywalker.backendapi.domain.user.infra.persistence.entity;

import org.sopt.doggywalker.backendapi.domain.user.domain.model.User;
import org.sopt.doggywalker.backendapi.global.infra.persistence.entity.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String loginId;

	protected UserEntity(final String name, final String loginId) {
		this.name = name;
		this.loginId = loginId;
	}

	public static UserEntity from(User user) {
		return new UserEntity(user.getName(), user.getLoginId());
	}

	public User toDomain() {
		return User.of(this.id, this.loginId, this.name);
	}
}

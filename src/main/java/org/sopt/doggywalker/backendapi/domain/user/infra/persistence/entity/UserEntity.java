package org.sopt.doggywalker.backendapi.domain.user.infra.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.doggywalker.backendapi.domain.user.domain.model.User;
import org.sopt.doggywalker.backendapi.global.infra.persistence.entity.BaseEntity;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  public UserEntity(final String name) {
    this.name = name;
  }

  public static UserEntity of(String name) {
    return new UserEntity(name);
  }

  public User toDomain() {
    return User.of(this.id, this.name);
  }
}

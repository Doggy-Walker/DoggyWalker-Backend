package org.sopt.doggywalker.backendapi.domain.user.infra.persistence;

import lombok.RequiredArgsConstructor;
import org.sopt.doggywalker.backendapi.domain.user.domain.model.User;
import org.sopt.doggywalker.backendapi.domain.user.domain.repository.UserRepository;
import org.sopt.doggywalker.backendapi.domain.user.infra.persistence.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

  private final SpringDataUserRepository springDataUserRepository;

  @Override
  public User save(final User user) {
    UserEntity entity = UserEntity.of(user.getName());
    UserEntity saved = springDataUserRepository.save(entity);

    return saved.toDomain();
  }
}

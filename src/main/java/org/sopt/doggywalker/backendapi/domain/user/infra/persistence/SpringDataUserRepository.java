package org.sopt.doggywalker.backendapi.domain.user.infra.persistence;

import org.sopt.doggywalker.backendapi.domain.user.infra.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataUserRepository extends JpaRepository<UserEntity, Long> {

  public boolean existsByLoginId(String loginId);

}

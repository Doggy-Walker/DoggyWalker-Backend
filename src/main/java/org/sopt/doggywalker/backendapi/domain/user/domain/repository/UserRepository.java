package org.sopt.doggywalker.backendapi.domain.user.domain.repository;

import org.sopt.doggywalker.backendapi.domain.user.domain.model.User;

public interface UserRepository {

  User save(User user);
}

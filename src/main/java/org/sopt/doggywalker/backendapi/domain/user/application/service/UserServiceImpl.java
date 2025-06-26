package org.sopt.doggywalker.backendapi.domain.user.application.service;

import lombok.RequiredArgsConstructor;
import org.sopt.doggywalker.backendapi.domain.user.domain.model.User;
import org.sopt.doggywalker.backendapi.domain.user.domain.repository.UserRepository;
import org.sopt.doggywalker.backendapi.domain.user.application.dto.request.CreateUserServiceRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  /**
   *
   * @param request User 생성 request
   * @return user 도메인 모델
   */
  @Override
  public User createUser(final CreateUserServiceRequest request) {
    User user = User.of(request.name());

    return userRepository.save(user);
  }
}

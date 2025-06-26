package org.sopt.doggywalker.backendapi.domain.user.api.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.doggywalker.backendapi.domain.user.application.facade.UserFacade;
import org.sopt.doggywalker.backendapi.domain.user.application.dto.request.CreateUserServiceRequest;
import org.sopt.doggywalker.backendapi.domain.user.application.dto.response.CreateUserServiceResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

  private final UserFacade userFacade;

  @PostMapping
  public ResponseEntity<CreateUserServiceResponse> create(
      @RequestBody CreateUserServiceRequest createUserRequest) {

    return ResponseEntity.ok(userFacade.register(createUserRequest));
  }
}

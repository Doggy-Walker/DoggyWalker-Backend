package org.sopt.doggywalker.backendapi.domain.user.domain.repository;

import java.util.List;

import org.sopt.doggywalker.backendapi.domain.user.domain.model.User;

public interface UserQueryRepository {

	List<User> getUsers();

	List<User> getUsersByNameLike(String name);
}

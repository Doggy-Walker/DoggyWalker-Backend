package org.sopt.pawkey.backendapi.domain.user.domain.model;

import org.sopt.pawkey.backendapi.domain.region.domain.model.Region;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class User {

	private final Long userId;
	private final String name;
	private final String gender;
	private final int age;
	private final Region region;

}
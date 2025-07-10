package org.sopt.pawkey.backendapi.domain.user.domain.model;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
public class User {

	private final Long userId;
	private final String name;
	private final String gender;
	private final String region_id;
	private int age;
	private String loginId;
	private final List<Long> petIds;
	private final List<Long> postIds;
	private final List<Long> reviewIds;
	private final List<Long> postLikeIds;

	@Builder
	public User(Long userId, String name, String gender, String region_id, List<Long> petIds, List<Long> postIds,
		List<Long> reviewIds, List<Long> postLikeIds, String loginId, int age) {
		this.userId = userId;
		this.name = name;
		this.gender = gender;
		this.region_id = region_id;
		this.petIds = petIds;
		this.postIds = postIds;
		this.reviewIds = reviewIds;
		this.postLikeIds = postLikeIds;
		this.loginId = loginId;
		this.age = age;
	}
}

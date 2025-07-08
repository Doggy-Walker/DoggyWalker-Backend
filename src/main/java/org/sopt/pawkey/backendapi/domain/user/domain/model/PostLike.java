package org.sopt.pawkey.backendapi.domain.user.domain.model;

import lombok.Getter;

@Getter
public class PostLike {

	private final Long postLikeId;
	private final Post post;
	private final User user;

	protected PostLike(Long postLikeId, Post post, User user) {
		this.postLikeId = postLikeId;
		this.post = post;
		this.user = user;
	}

	public static PostLike createPostLike(Post post, User user) {
		return new PostLike(null, post, user);
	}

	public static PostLike of(Long postLikeId, Post post, User user) {
		return new PostLike(postLikeId, post, user);
	}
}
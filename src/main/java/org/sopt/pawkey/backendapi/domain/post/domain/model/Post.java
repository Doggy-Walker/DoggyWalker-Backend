package org.sopt.pawkey.backendapi.domain.post.domain.model;

import java.time.LocalDateTime;

import org.sopt.pawkey.backendapi.domain.user.domain.model.User;

import lombok.Getter;

@Getter
public class Post {

	private final Long postId;
	private final User writer;
	private final Long routeId;
	private final String title;
	private final String description;
	private final Boolean isPublic;

	protected Post(Long postId, User writer, Long routeId, String title, String description, Boolean isPublic) {
		this.postId = postId;
		this.writer = writer;
		this.routeId = routeId;
		this.title = title;
		this.description = description;
		this.isPublic = isPublic;
	}

	public static Post createPost(User writer, Long routeId, String title, String description, Boolean isPublic) {
		return new Post(null, writer, routeId, title, description, isPublic);
	}

	public static Post of(Long postId, User writer, Long routeId, String title, String description,
		Boolean isPublic) {
		return new Post(postId, writer, routeId, title, description, isPublic);
	}
}

package org.sopt.pawkey.backendapi.domain.user.domain.model;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class Post {

	private final Long post_id;
	private final User writer;
	private final Long route_id;
	private final String title;
	private final String description;
	private final Boolean is_public;
	private final LocalDateTime created_at;
	private final LocalDateTime updated_at;

	protected Post(Long post_id, User writer, Long route_id, String title, String description, Boolean is_public,
		LocalDateTime created_at, LocalDateTime updated_at) {
		this.post_id = post_id;
		this.writer = writer;
		this.route_id = route_id;
		this.title = title;
		this.description = description;
		this.is_public = is_public;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public static Post createPost(User writer, Long route_id, String title, String description, Boolean is_public) {
		return new Post(null, writer, route_id, title, description, is_public, null, null);
	}

	public static Post of(Long post_id, User writer, Long route_id, String title, String description,
		Boolean is_public, LocalDateTime created_at, LocalDateTime updated_at) {
		return new Post(post_id, writer, route_id, title, description, is_public, created_at, updated_at);
	}
}

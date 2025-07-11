package org.sopt.pawkey.backendapi.domain.post.domain.model;

import org.sopt.pawkey.backendapi.domain.routes.domain.model.Route;
import org.sopt.pawkey.backendapi.domain.user.domain.model.User;

import lombok.Getter;

@Getter
public class Post {

	private final Long postId;
	private final User writer;

	private final Route route;
	private final String title;
	private final String description;
	private final Boolean isPublic;

	protected Post(Long postId, User writer, Route route, String title, String description, Boolean isPublic) {
		this.postId = postId;
		this.writer = writer;
		this.route = route;
		this.title = title;
		this.description = description;
		this.isPublic = isPublic;
	}

	public static Post createPost(User writer, Route route, String title, String description, Boolean isPublic) {
		return new Post(null, writer, route, title, description, isPublic);
	}

	public static Post of(Long postId, User writer, Route route, String title, String description,
		Boolean isPublic) {
		return new Post(postId, writer, route, title, description, isPublic);
	}

}

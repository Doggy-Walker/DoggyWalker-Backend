package org.sopt.pawkey.backendapi.domain.post.application.service;

import org.sopt.pawkey.backendapi.domain.post.domain.model.Post;
import org.sopt.pawkey.backendapi.domain.user.application.dto.request.CreateUserCommand;
import org.sopt.pawkey.backendapi.domain.user.domain.model.User;

public interface PostLikeService {

	/**
	 * @param user 좋아요를 누른 유저
	 * @param post 좋아요를 누를 게시글
	 */
	void like(final User user, final Post post);
}

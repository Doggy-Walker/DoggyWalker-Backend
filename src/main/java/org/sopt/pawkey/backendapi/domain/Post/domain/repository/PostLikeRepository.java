package org.sopt.pawkey.backendapi.domain.post.domain.repository;

import org.sopt.pawkey.backendapi.domain.post.domain.model.Post;
import org.sopt.pawkey.backendapi.domain.post.domain.model.PostLike;
import org.sopt.pawkey.backendapi.domain.user.domain.model.User;

public interface PostLikeRepository {
	PostLike save(PostLike postLike);

	boolean existsByUserAndPost(Long userId, Long postId);
}
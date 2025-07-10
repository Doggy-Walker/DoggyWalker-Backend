package org.sopt.pawkey.backendapi.domain.post.domain.repository;

import org.sopt.pawkey.backendapi.domain.post.domain.model.PostLike;

public interface PostLikeRepository {
	PostLike save(PostLike postLike);

	boolean existsByUserUserIdAndPostPostId(Long userId, Long postId);
}
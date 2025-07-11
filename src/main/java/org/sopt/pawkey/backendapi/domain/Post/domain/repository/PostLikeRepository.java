package org.sopt.pawkey.backendapi.domain.post.domain.repository;

import org.sopt.pawkey.backendapi.domain.post.domain.model.PostLike;

public interface PostLikeRepository {
	PostLike save(PostLike postLike);
	boolean existsByUserAndPost(Long userId, Long postId);
}
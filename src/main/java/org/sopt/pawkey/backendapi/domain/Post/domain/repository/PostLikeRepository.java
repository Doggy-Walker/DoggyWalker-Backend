package org.sopt.pawkey.backendapi.domain.post.domain.repository;

import org.sopt.pawkey.backendapi.domain.post.infra.persistence.entity.PostLikeEntity;

public interface PostLikeRepository {
	PostLikeEntity save(PostLikeEntity postLike);

	boolean existsByUserIdAndPostId(Long userId, Long postId);
}
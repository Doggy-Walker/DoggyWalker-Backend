package org.sopt.pawkey.backendapi.domain.post.infra.persistence.repository;

import org.sopt.pawkey.backendapi.domain.post.infra.persistence.entity.PostLikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataPostLikeRepository extends JpaRepository<PostLikeEntity, Long> {
	boolean existsByUser_UserIdAndPost_PostId(Long userId, Long postId);
}
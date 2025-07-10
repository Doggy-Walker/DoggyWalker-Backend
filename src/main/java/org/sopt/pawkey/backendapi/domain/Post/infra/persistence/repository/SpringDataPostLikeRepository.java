package org.sopt.pawkey.backendapi.domain.post.infra.persistence.repository;

import org.sopt.pawkey.backendapi.domain.post.infra.persistence.entity.PostEntity;
import org.sopt.pawkey.backendapi.domain.post.infra.persistence.entity.PostLikeEntity;
import org.sopt.pawkey.backendapi.domain.user.infra.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataPostLikeRepository extends JpaRepository<PostLikeEntity, Long> {

	boolean existsByUserUserIdAndPostPostId(Long userId, Long postId);
}
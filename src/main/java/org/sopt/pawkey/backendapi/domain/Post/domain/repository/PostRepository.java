package org.sopt.pawkey.backendapi.domain.post.domain.repository;

import java.util.Optional;

import org.sopt.pawkey.backendapi.domain.post.infra.persistence.entity.PostEntity;

public interface PostRepository {
	Optional<PostEntity> findById(Long postId);
}
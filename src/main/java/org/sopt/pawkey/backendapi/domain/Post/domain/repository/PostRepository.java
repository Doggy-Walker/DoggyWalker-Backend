package org.sopt.pawkey.backendapi.domain.post.domain.repository;

import java.util.Optional;

import org.sopt.pawkey.backendapi.domain.post.domain.model.Post;

public interface PostRepository {
	Optional<Post> findById(Long postId);
}
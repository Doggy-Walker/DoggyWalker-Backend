package org.sopt.pawkey.backendapi.domain.post.domain.repository;

import org.sopt.pawkey.backendapi.domain.post.domain.model.Post;

public interface PostRepository {
	Post findById(Long postId);
}
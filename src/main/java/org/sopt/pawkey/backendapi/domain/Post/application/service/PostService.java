package org.sopt.pawkey.backendapi.domain.post.application.service;

import org.sopt.pawkey.backendapi.domain.post.domain.model.Post;

public interface PostService {
	Post findById(Long id);
}

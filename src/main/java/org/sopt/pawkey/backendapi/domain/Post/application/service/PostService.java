package org.sopt.pawkey.backendapi.domain.post.application.service;

import org.sopt.pawkey.backendapi.domain.post.infra.persistence.entity.PostEntity;

public interface PostService {
	PostEntity findById(Long postId);
}

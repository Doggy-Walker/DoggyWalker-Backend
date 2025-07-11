package org.sopt.pawkey.backendapi.domain.post.application.service;

import org.sopt.pawkey.backendapi.domain.post.domain.repository.PostRepository;
import org.sopt.pawkey.backendapi.domain.post.exception.PostBusinessException;
import org.sopt.pawkey.backendapi.domain.post.exception.PostErrorCode;
import org.sopt.pawkey.backendapi.domain.post.infra.persistence.entity.PostEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

	private final PostRepository postRepository;

	@Override
	public PostEntity findById(Long postId) {
		return postRepository.findById(postId)
			.orElseThrow(() -> new PostBusinessException(PostErrorCode.POST_NOT_FOUND));
	}
}
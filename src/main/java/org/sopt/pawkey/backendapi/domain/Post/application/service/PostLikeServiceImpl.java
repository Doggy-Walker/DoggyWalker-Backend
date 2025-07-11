package org.sopt.pawkey.backendapi.domain.post.application.service;

import org.sopt.pawkey.backendapi.domain.post.domain.model.Post;
import org.sopt.pawkey.backendapi.domain.post.domain.model.PostLike;
import org.sopt.pawkey.backendapi.domain.post.domain.repository.PostLikeRepository;
import org.sopt.pawkey.backendapi.domain.post.exception.PostLikeBusinessException;
import org.sopt.pawkey.backendapi.domain.post.exception.PostLikeErrorCode;
import org.sopt.pawkey.backendapi.domain.user.domain.model.User;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostLikeServiceImpl implements PostLikeService {

	private final PostLikeRepository postLikeRepository;

	/**
	 * 이미 좋아요가 존재하면 예외 발생, 없으면 저장
	 */
	@Override
	public void like(final User user, final Post post) {
		boolean exists = postLikeRepository.existsByUserIdAndPostId(user.getUserId(), post.getPostId());
		if (exists) {
			throw new PostLikeBusinessException(PostLikeErrorCode.DUPLICATE_LIKE);
		}

		final PostLike postLike = PostLike.createPostLike(post, user);
		postLikeRepository.save(postLike);
	}
}
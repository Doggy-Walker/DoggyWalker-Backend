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
	 * 본인 게시글이면 예외, 이미 좋아요가 존재하면 예외, 없으면 저장
	 */
	@Override
	public void like(final User user, final Post post) {
		// 본인 게시글에 좋아요 금지
		if (post.getWriter().getUserId().equals(user.getUserId())) {
			throw new PostLikeBusinessException(PostLikeErrorCode.CANNOT_LIKE_OWN_POST);
		}

		// 이미 좋아요한 경우 예외
		boolean exists = postLikeRepository.existsByUserIdAndPostId(user.getUserId(), post.getPostId());
		if (exists) {
			throw new PostLikeBusinessException(PostLikeErrorCode.DUPLICATE_LIKE);
		}

		// 좋아요 저장
		final PostLike postLike = PostLike.createPostLike(post, user);
		postLikeRepository.save(postLike);
	}
}
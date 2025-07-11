package org.sopt.pawkey.backendapi.domain.post.application.service;

import org.sopt.pawkey.backendapi.domain.post.domain.repository.PostLikeRepository;
import org.sopt.pawkey.backendapi.domain.post.exception.PostLikeBusinessException;
import org.sopt.pawkey.backendapi.domain.post.exception.PostLikeErrorCode;
import org.sopt.pawkey.backendapi.domain.post.infra.persistence.entity.PostEntity;
import org.sopt.pawkey.backendapi.domain.post.infra.persistence.entity.PostLikeEntity;
import org.sopt.pawkey.backendapi.domain.user.infra.persistence.entity.UserEntity;
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
	public void like(final UserEntity user, final PostEntity post) {
		// 본인 게시글에 좋아요 금지
		if (post.getUser().getUserId().equals(user.getUserId())) {
			throw new PostLikeBusinessException(PostLikeErrorCode.CANNOT_LIKE_OWN_POST);
		}

		// 이미 좋아요한 경우 예외
		boolean exists = postLikeRepository.existsByUserIdAndPostId(user.getUserId(), post.getPostId());
		if (exists) {
			throw new PostLikeBusinessException(PostLikeErrorCode.DUPLICATE_LIKE);
		}

		// 좋아요 저장
		final PostLikeEntity postLike = PostLikeEntity.builder()
			.post(post)
			.user(user)
			.build();
		postLikeRepository.save(postLike);
	}
}
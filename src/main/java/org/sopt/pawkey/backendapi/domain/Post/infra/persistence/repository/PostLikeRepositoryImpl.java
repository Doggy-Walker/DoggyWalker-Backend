// PostLikeRepositoryImpl.java
package org.sopt.pawkey.backendapi.domain.post.infra.persistence.repository;

import lombok.RequiredArgsConstructor;
import org.sopt.pawkey.backendapi.domain.post.domain.model.PostLike;
import org.sopt.pawkey.backendapi.domain.post.domain.repository.PostLikeRepository;
import org.sopt.pawkey.backendapi.domain.post.infra.mapper.PostLikeMapper;
import org.sopt.pawkey.backendapi.domain.post.infra.persistence.entity.PostLikeEntity;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PostLikeRepositoryImpl implements PostLikeRepository {
	private final SpringDataPostLikeRepository springDataPostLikeRepository;
	private final PostLikeMapper postLikeMapper;

	@Override
	public PostLike save(PostLike postLike) {
		PostLikeEntity entity = postLikeMapper.toEntity(postLike);
		return postLikeMapper.toDomain(springDataPostLikeRepository.save(entity));
	}

	@Override
	public boolean existsByUserUserIdAndPostPostId(Long userId, Long postId) {
		return springDataPostLikeRepository.existsByUserUserIdAndPostPostId(userId, postId);
	}
}

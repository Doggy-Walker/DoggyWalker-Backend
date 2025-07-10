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
	private final SpringDataPostLikeRepository jpaRepository;
	private final PostLikeMapper postLikeMapper;

	@Override
	public PostLike save(PostLike postLike) {
		PostLikeEntity entity = postLikeMapper.toEntity(postLike);
		return postLikeMapper.toDomain(jpaRepository.save(entity));
	}

	@Override
	public boolean existsByUserAndPost(Long userId, Long postId) {
		return false;
		// return jpaRepository.existsByUserIdAndPostId(userId, postId);
	}
}

// PostLikeRepositoryImpl.java
package org.sopt.pawkey.backendapi.domain.post.infra.persistence.repository;

import org.sopt.pawkey.backendapi.domain.post.domain.model.PostLike;
import org.sopt.pawkey.backendapi.domain.post.domain.repository.PostLikeRepository;
import org.sopt.pawkey.backendapi.domain.post.infra.mapper.PostLikeMapper;
import org.sopt.pawkey.backendapi.domain.post.infra.mapper.PostMapper;
import org.sopt.pawkey.backendapi.domain.user.infra.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PostLikeRepositoryImpl implements PostLikeRepository {

	private final SpringDataPostLikeRepository jpaRepository;
	private final PostLikeMapper postLikeMapper;
	private final UserMapper userMapper;
	private final PostMapper postMapper;

	@Override
	public PostLike save(PostLike postLike) {
		// Domain → Entity
		var entity = postLikeMapper.toEntity(postLike);
		var saved = jpaRepository.save(entity);
		return postLikeMapper.toDomain(saved); // Entity → Domain
	}

	@Override
	public boolean existsByUserIdAndPostId(Long userId, Long postId) {
		return jpaRepository.existsByUser_UserIdAndPost_PostId(userId, postId);
	}
}
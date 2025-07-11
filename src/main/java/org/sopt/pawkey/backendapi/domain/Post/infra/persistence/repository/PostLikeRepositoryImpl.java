// PostLikeRepositoryImpl.java
package org.sopt.pawkey.backendapi.domain.post.infra.persistence.repository;

import lombok.RequiredArgsConstructor;
import org.sopt.pawkey.backendapi.domain.post.domain.model.PostLike;
import org.sopt.pawkey.backendapi.domain.post.domain.repository.PostLikeRepository;
import org.sopt.pawkey.backendapi.domain.post.infra.mapper.PostLikeMapper;
import org.sopt.pawkey.backendapi.domain.post.infra.mapper.PostMapper;
import org.sopt.pawkey.backendapi.domain.post.infra.persistence.entity.PostLikeEntity;
import org.sopt.pawkey.backendapi.domain.user.infra.mapper.UserMapper;
import org.springframework.stereotype.Repository;

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
	public boolean existsByUserAndPost(Long userId, Long postId) {
		// userId → UserEntity
		var userEntity = userMapper.toEntity(userId);   // ★ userId만으로 Entity 생성
		var postEntity = postMapper.toEntity(postId);   // ★ postId만으로 Entity 생성

		return jpaRepository.existsByUserAndPost(userEntity, postEntity);
	}
}
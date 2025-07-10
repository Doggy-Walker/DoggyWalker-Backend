package org.sopt.pawkey.backendapi.domain.post.infra.persistence.repository;

import org.sopt.pawkey.backendapi.domain.post.domain.model.Post;
import org.sopt.pawkey.backendapi.domain.post.domain.model.PostLike;
import org.sopt.pawkey.backendapi.domain.post.domain.repository.PostLikeRepository;
import org.sopt.pawkey.backendapi.domain.post.domain.repository.PostRepository;
import org.sopt.pawkey.backendapi.domain.post.infra.mapper.PostLikeMapper;
import org.sopt.pawkey.backendapi.domain.post.infra.mapper.PostMapper;
import org.sopt.pawkey.backendapi.domain.post.infra.persistence.entity.PostEntity;
import org.sopt.pawkey.backendapi.domain.user.domain.repository.UserRepository;
import org.sopt.pawkey.backendapi.domain.user.infra.persistence.entity.UserEntity;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {

	private final SpringDataPostRepository jpaRepository;
	private final PostMapper postMapper;

	@Override
	public Post findById(Long postId) {
		return postMapper.toDomain(
			jpaRepository.findById(postId)
				.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 Post입니다."))
		);
	}
}
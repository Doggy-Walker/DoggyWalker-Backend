package org.sopt.pawkey.backendapi.domain.post.infra.persistence.repository;

import java.util.Optional;

import org.sopt.pawkey.backendapi.domain.post.domain.model.Post;
import org.sopt.pawkey.backendapi.domain.post.domain.repository.PostRepository;
import org.sopt.pawkey.backendapi.domain.post.infra.mapper.PostMapper;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {

	private final SpringDataPostRepository jpaRepository;
	private final PostMapper postMapper;

	@Override
	public Optional<Post> findById(Long postId) {
		return jpaRepository.findById(postId)
			.map(postMapper::toDomain);
	}
}
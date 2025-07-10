package org.sopt.pawkey.backendapi.domain.post.infra.mapper;

import org.sopt.pawkey.backendapi.domain.post.domain.model.PostLike;
import org.sopt.pawkey.backendapi.domain.post.infra.persistence.entity.PostLikeEntity;
import org.sopt.pawkey.backendapi.domain.user.infra.mapper.UserMapper;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PostLikeMapper {

	private final PostMapper postMapper;
	private final UserMapper userMapper;

	public PostLike toDomain(PostLikeEntity entity) {
		return PostLike.of(
			entity.getPostLikeId(),
			postMapper.toDomain(entity.getPost()),
			userMapper.toDomain(entity.getUser())
		);
	}

	public PostLikeEntity toEntity(PostLike domain) {
		return PostLikeEntity.create(
			domain.getPostLikeId(),
			postMapper.toEntity(domain.getPost()),
			userMapper.toEntity(domain.getUser())
		);
	}
}
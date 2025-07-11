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

	public PostLikeEntity toEntity(PostLike domain) {
		return PostLikeEntity.builder()
			.user(userMapper.toEntity(domain.getUser()))
			.post(postMapper.toEntity(domain.getPost()))
			.build();
	}

	public PostLike toDomain(PostLikeEntity entity) {
		return PostLike.createPostLike(
			postMapper.toDomain(entity.getPost()),
			userMapper.toDomain(entity.getUser())
		);
	}
}
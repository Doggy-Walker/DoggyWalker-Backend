package org.sopt.pawkey.backendapi.domain.post.infra.mapper;

import org.sopt.pawkey.backendapi.domain.post.domain.model.Post;
import org.sopt.pawkey.backendapi.domain.post.infra.persistence.entity.PostEntity;
import org.sopt.pawkey.backendapi.domain.routes.infra.mapper.RouteMapper;
import org.sopt.pawkey.backendapi.domain.user.infra.mapper.UserMapper;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PostMapper {

	private final UserMapper userMapper;
	private final RouteMapper routeMapper;

	public Post toDomain(PostEntity entity) {
		return Post.of(
			entity.getPostId(),
			userMapper.toDomain(entity.getUser()),
			routeMapper.toDomain(entity.getRoute()),
			null,  // title은 현재 도메인에 없음
			entity.getDescription(),
			entity.isPublic()
		);
	}

	public PostEntity toEntity(Post domain) {
		return PostEntity.create(
			domain.getPostId(),
			domain.getDescription(),
			domain.getIsPublic(),
			userMapper.toEntity(domain.getWriter()),
			routeMapper.toEntity(domain.getRoute())
		);
	}
}
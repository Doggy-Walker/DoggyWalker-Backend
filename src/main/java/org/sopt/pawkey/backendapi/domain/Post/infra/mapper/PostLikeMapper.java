package org.sopt.pawkey.backendapi.domain.post.infra.mapper;

import org.sopt.pawkey.backendapi.domain.post.domain.model.PostLike;
import org.sopt.pawkey.backendapi.domain.post.infra.persistence.entity.PostEntity;
import org.sopt.pawkey.backendapi.domain.post.infra.persistence.entity.PostLikeEntity;
import org.sopt.pawkey.backendapi.domain.user.infra.mapper.UserMapper;
import org.sopt.pawkey.backendapi.domain.user.infra.persistence.entity.UserEntity;
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
		PostEntity postEntity = postMapper.toEntity(domain.getPost());
		UserEntity userEntity = userMapper.toEntity(domain.getUser());

		// protected 생성자 대신 정적 팩토리 메서드나 builder 패턴을 사용할 수 있음
		return new PostLikeEntity(
			domain.getPostLikeId(),
			postEntity,
			userEntity
		);
	}
}
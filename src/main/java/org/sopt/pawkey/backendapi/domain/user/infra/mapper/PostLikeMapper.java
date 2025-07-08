package org.sopt.pawkey.backendapi.domain.user.infra.mapper;

import org.sopt.pawkey.backendapi.domain.user.domain.model.PostLike;
import org.sopt.pawkey.backendapi.domain.user.infra.persistence.entity.PostLikeEntity;
import org.springframework.stereotype.Component;

@Component

public class PostLikeMapper {

	// public static PostLike toDomain(PostLikeEntity entity) {
	// 	return PostLike.of(
	// 		entity.getPost_like_id(),
	// 		PostMapper.toDomain(entity.getPost()),
	// 		UserMapper.toDomain(entity.getUser())
	// 	);
	// }
	//
	// public static PostLikeEntity toEntity(PostLike postLike) {
	// 	return PostLikeEntity.builder()
	// 		.post_like_id(postLike.getPostLikeId())
	// 		.post(PostMapper.toEntity(postLike.getPost()))
	// 		.user(UserMapper.toEntity(postLike.getUser()))
	// 		.build();
	// }
}
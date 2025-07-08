package org.sopt.pawkey.backendapi.domain.post.infra.mapper;

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
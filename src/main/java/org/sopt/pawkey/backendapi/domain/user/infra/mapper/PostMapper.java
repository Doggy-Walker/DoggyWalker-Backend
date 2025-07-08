package org.sopt.pawkey.backendapi.domain.user.infra.mapper;

import org.sopt.pawkey.backendapi.domain.user.domain.model.Post;
import org.sopt.pawkey.backendapi.domain.user.domain.model.User;
import org.sopt.pawkey.backendapi.domain.user.infra.persistence.entity.PostEntity;
import org.sopt.pawkey.backendapi.domain.user.infra.persistence.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

	// private final UserMapper userMapper;
	//
	// public PostMapper(UserMapper userMapper) {
	// 	this.userMapper = userMapper;
	// }
	//
	// /**
	//  * 도메인 모델을 DB 저장용 엔티티로 변환
	//  *
	//  * @param domain 도메인 모델
	//  * @return 엔티티 객체
	//  */
	// public PostEntity toEntity(Post domain) {
	// 	UserEntity writerEntity = userMapper.toEntity(domain.getWriter());
	//
	// 	return PostEntity.builder()
	// 		.post_id(domain.getPost_id())
	// 		.writer(writerEntity)
	// 		.route_id(domain.getRoute_id())
	// 		.title(domain.getTitle())
	// 		.description(domain.getDescription())
	// 		.is_public(domain.getIs_public())
	// 		.created_at(domain.getCreated_at())
	// 		.updated_at(domain.getUpdated_at())
	// 		.build();
	// }
	//
	// /**
	//  * DB 엔티티를 도메인 모델로 변환
	//  *
	//  * @param entity 엔티티 객체
	//  * @return 도메인 모델
	//  */
	// public Post toDomain(PostEntity entity) {
	// 	User writerDomain = userMapper.toDomain(entity.getWriter());
	//
	// 	return Post.of(
	// 		entity.getPost_id(),
	// 		writerDomain,
	// 		entity.getRoute_id(),
	// 		entity.getTitle(),
	// 		entity.getDescription(),
	// 		entity.getIs_public(),
	// 		entity.getCreated_at(),
	// 		entity.getUpdated_at()
	// 	);
	// }
}

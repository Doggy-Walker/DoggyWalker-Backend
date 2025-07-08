package org.sopt.pawkey.backendapi.domain.user.infra.persistence.entity;

import org.sopt.pawkey.backendapi.global.infra.persistence.entity.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "post_like")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PROTECTED)
public class PostLikeEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long post_like_id;

	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "post_id", nullable = false)
	// private PostEntity post;
	//
	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "user_id", nullable = false)
	// private UserEntity user;
}

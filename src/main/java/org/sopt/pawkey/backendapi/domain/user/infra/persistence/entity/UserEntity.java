package org.sopt.pawkey.backendapi.domain.user.infra.persistence.entity;

import java.util.ArrayList;
import java.util.List;

import org.sopt.pawkey.backendapi.domain.pet.infra.persistence.entity.PetEntity;
import org.sopt.pawkey.backendapi.domain.post.infra.persistence.entity.PostEntity;
import org.sopt.pawkey.backendapi.domain.post.infra.persistence.entity.PostLikeEntity;
import org.sopt.pawkey.backendapi.domain.region.infra.persistence.entity.RegionEntity;
import org.sopt.pawkey.backendapi.domain.review.infra.persistence.entity.ReviewEntity;
import org.sopt.pawkey.backendapi.global.infra.persistence.entity.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PROTECTED)
public class UserEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String name;
	private String gender;
	private int age;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "region_id")
	private RegionEntity region;

	private String loginId;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PetEntity> petEntityList = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PostEntity> postEntityList = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ReviewEntity> reviewEntityList = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PostLikeEntity> postLikeEntityList = new ArrayList<>();

	public static UserEntity createEntity(String name, String loginId) {
		return null;

	}
}

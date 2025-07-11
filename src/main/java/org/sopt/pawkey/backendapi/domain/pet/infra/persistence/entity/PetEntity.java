package org.sopt.pawkey.backendapi.domain.pet.infra.persistence.entity;

import java.util.ArrayList;
import java.util.List;

import org.sopt.pawkey.backendapi.domain.image.infra.persistence.entity.ImageEntity;
import org.sopt.pawkey.backendapi.domain.user.infra.persistence.entity.UserEntity;
import org.sopt.pawkey.backendapi.global.infra.persistence.entity.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pets")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PetEntity extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pet_id")
	private Long petId;

	//User 연관관계 추가
	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Column(name = "gender", nullable = false, length = 10)
	private String gender;

	@Column(name = "age")
	private int age;

	@Column(name = "is_age_known", nullable = false)
	private boolean isAgeKnown;

	//Image 연관관계 추가
	@OneToOne
	@JoinColumn(name = "image_id")
	private ImageEntity profileImage;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity user;

	private boolean isNeutered;

	@Column(name = "breed", length = 50)
	private String breed;

	@OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PetTraitSelectedEntity> petTraitSelectedEntityList = new ArrayList<>();

	@Builder
	public PetEntity(Long petId,
		String name,
		String gender,
		int age,
		boolean isAgeKnown,
		ImageEntity profileImage,
		UserEntity user,
		boolean isNeutered,
		String breed,
		List<PetTraitSelectedEntity> petTraitSelectedEntityList) {
		this.petId = petId;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.isAgeKnown = isAgeKnown;
		this.profileImage = profileImage;
		this.user = user;
		this.isNeutered = isNeutered;
		this.breed = breed;
		this.petTraitSelectedEntityList =
			petTraitSelectedEntityList != null ? petTraitSelectedEntityList : new ArrayList<>();
	}
}

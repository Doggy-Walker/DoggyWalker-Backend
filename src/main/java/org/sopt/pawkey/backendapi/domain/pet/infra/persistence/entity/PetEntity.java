package org.sopt.pawkey.backendapi.domain.pet.infra.persistence.entity;

import org.sopt.pawkey.backendapi.global.infra.persistence.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pets")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PROTECTED)
public class PetEntity extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pet_id")
	private Long pet_id;

	//User 연관관계 추가
	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Column(name = "gender", nullable = false, length = 10)
	private String gender;

	@Column(name = "age")
	private int age;

	@Column(name = "is_age_known", nullable = false)
	private boolean is_age_known;

	//Image 연관관계 추가

	private boolean is_neutered;

	@Column(name = "breed", length = 50)
	private String breed;

}

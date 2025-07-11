package org.sopt.pawkey.backendapi.domain.pet.infra.persistence.entity;

import java.util.ArrayList;
import java.util.List;

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
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pet_trait_option")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class PetTraitOptionEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pet_trait_option_id")
	private Long id;

	//PetTraitCategory 연관관계
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pet_trait_category_id")
	private PetTraitCategoryEntity petTraitCategory;

	@Column(name = "option_text", nullable = false, length = 50)
	private String optionText;

	@OneToMany(mappedBy = "petTraitOption", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PetTraitSelectedEntity> petTraitSelectedEntityList = new ArrayList<>();
}

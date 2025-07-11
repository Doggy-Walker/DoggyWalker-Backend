package org.sopt.pawkey.backendapi.domain.pet.infra.mapper;

import org.sopt.pawkey.backendapi.domain.pet.domain.model.PetTraitCategory;
import org.sopt.pawkey.backendapi.domain.pet.domain.model.PetTraitOption;
import org.sopt.pawkey.backendapi.domain.pet.infra.persistence.entity.PetTraitCategoryEntity;
import org.sopt.pawkey.backendapi.domain.pet.infra.persistence.entity.PetTraitOptionEntity;
import org.springframework.stereotype.Component;

@Component
public class PetTraitOptionMapper {

	public static PetTraitOption toDomain(PetTraitOptionEntity entity) {
		if (entity == null) return null;

		return new PetTraitOption(
			entity.getId(),
			new PetTraitCategory(
				entity.getPetTraitCategory().getId(),
				null, // name은 필요하면
				null  // Option 리스트는 null (순환 방지)
			),
			entity.getOptionText()
		);
	}

	public static PetTraitOptionEntity toEntity(PetTraitOption petTraitOption) {
		if (petTraitOption == null) return null;


		// PetTraitCategoryEntity 의 최소한의 객체 생성 (ID만 세팅)
		PetTraitCategoryEntity minimalCategoryEntity = PetTraitCategoryEntity.builder()
			.id(petTraitOption.getPetTraitCategory().getId())
			.build();
		return PetTraitOptionEntity.builder()
			.id(petTraitOption.getId())
			.petTraitCategory(minimalCategoryEntity)
			.optionText(petTraitOption.getOptionText())
			.build();
	}
}
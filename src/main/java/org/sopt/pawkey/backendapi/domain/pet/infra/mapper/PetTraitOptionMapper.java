package org.sopt.pawkey.backendapi.domain.pet.infra.mapper;

import org.sopt.pawkey.backendapi.domain.pet.domain.model.PetTraitOption;
import org.sopt.pawkey.backendapi.domain.pet.infra.persistence.entity.PetTraitOptionEntity;
import org.springframework.stereotype.Component;

@Component
public class PetTraitOptionMapper {

	public static PetTraitOption toDomain(PetTraitOptionEntity entity) {
		if (entity == null) return null;

		return new PetTraitOption(
			entity.getId(),
			PetTraitCategoryMapper.toDomain(entity.getPetTraitCategory()),
			entity.getOptionText()
		);
	}

	public static PetTraitOptionEntity toEntity(PetTraitOption petTraitOption) {
		if (petTraitOption == null) return null;

		return PetTraitOptionEntity.builder()
			.id(domain.getId())
			.petTraitCategory(PetTraitCategoryMapper.toEntity(domain.getPetTraitCategory()))
			.optionText(domain.getOptionText())
			.build();
	}
}
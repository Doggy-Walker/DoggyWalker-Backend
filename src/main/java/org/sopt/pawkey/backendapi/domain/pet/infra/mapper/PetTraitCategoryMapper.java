package org.sopt.pawkey.backendapi.domain.pet.infra.mapper;

import java.util.stream.Collectors;

import org.sopt.pawkey.backendapi.domain.pet.domain.model.PetTraitCategory;
import org.sopt.pawkey.backendapi.domain.pet.infra.persistence.entity.PetTraitCategoryEntity;

public class PetTraitCategoryMapper {

	public static PetTraitCategory toDomain(PetTraitCategoryEntity entity) {
		return new PetTraitCategory(
			entity.getId(),
			entity.getCategoryName(),
			entity.getPetTraitOptionEntityList().stream()
				.map(PetTraitOptionMapper::toDomain)
				.collect(Collectors.toList())
		);
	}


}



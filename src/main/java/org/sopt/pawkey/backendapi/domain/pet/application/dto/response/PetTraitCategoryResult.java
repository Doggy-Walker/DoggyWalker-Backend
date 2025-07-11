package org.sopt.pawkey.backendapi.domain.pet.application.dto.response;

import java.util.List;

import org.sopt.pawkey.backendapi.domain.pet.infra.persistence.entity.PetTraitCategoryEntity;
import org.sopt.pawkey.backendapi.domain.pet.infra.persistence.entity.PetTraitOptionEntity;

public record PetTraitCategoryResult(
	Long id,
	String name,
	List<PetTraitOptionResult> options
) {

	public static PetTraitCategoryResult fromEntity(PetTraitCategoryEntity petTraitCategory) {
		return new PetTraitCategoryResult(
			petTraitCategory.getId(),
			petTraitCategory.getCategoryName(),
			petTraitCategory.getPetTraitOptionEntityList().stream()
				.map(PetTraitOptionResult::fromEntity)
				.toList()
		);
	}

	public record PetTraitOptionResult(
		Long id,
		String text
	) {
		public static PetTraitOptionResult fromEntity(PetTraitOptionEntity entity) {
			return new PetTraitOptionResult(entity.getId(), entity.getOptionText());
		}
	}
}

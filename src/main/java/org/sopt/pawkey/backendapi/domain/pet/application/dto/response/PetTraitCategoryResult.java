package org.sopt.pawkey.backendapi.domain.pet.application.dto.response;

import java.util.List;

import org.sopt.pawkey.backendapi.domain.pet.domain.model.PetTraitCategory;
import org.sopt.pawkey.backendapi.domain.pet.domain.model.PetTraitOption;



public record PetTraitCategoryResult(
	Long id,
	String name,
	List<PetTraitOptionResult> options
) {

	public static PetTraitCategoryResult fromDomain(PetTraitCategory petTraitCategory) {
		return new PetTraitCategoryResult(
			petTraitCategory.getId(),
			petTraitCategory.getCategoryName(),
			petTraitCategory.getPetTraitOptionList().stream()
				.map(PetTraitOptionResult::fromDomain)
				.toList()
		);
	}

	public record PetTraitOptionResult(
		Long id,
		String text
	) {
		public static PetTraitOptionResult fromDomain(PetTraitOption domain) {
			return new PetTraitOptionResult(domain.getId(), domain.getOptionText());
		}
	}
}

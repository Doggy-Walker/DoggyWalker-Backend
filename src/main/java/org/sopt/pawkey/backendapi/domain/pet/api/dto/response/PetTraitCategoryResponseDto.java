package org.sopt.pawkey.backendapi.domain.pet.api.dto.response;

import java.util.List;

import org.sopt.pawkey.backendapi.domain.pet.application.dto.response.PetTraitCategoryResult;

public record PetTraitCategoryResponseDto(
	Long petTraitCategoryId,
	String petTraitCategoryName,
	List<PetTraitCategoryOptionResponseDto> petTraitCategoryOptions
) {
	public static PetTraitCategoryResponseDto from(PetTraitCategoryResult result) {
		return new PetTraitCategoryResponseDto(
			result.id(),
			result.name(),
			result.options().stream()
				.map(PetTraitCategoryOptionResponseDto::from)
				.toList()
		);
	}

	public record PetTraitCategoryOptionResponseDto(
		Long petTraitCategoryOptionId,
		String petTraitCategoryOptionText
	) {
		public static PetTraitCategoryOptionResponseDto from(PetTraitCategoryResult.PetTraitOptionResult result) {
			return new PetTraitCategoryOptionResponseDto(
				result.id(),
				result.text()
			);
		}
	}
}
package org.sopt.pawkey.backendapi.domain.pet.api.dto.response;

import java.util.List;

import org.sopt.pawkey.backendapi.domain.pet.application.dto.response.PetTraitCategoryResult;

public record PetTraitCategoryListResponseDto(
	List<PetTraitCategoryResponseDto> petTraitCategoryList
) {
	public static PetTraitCategoryListResponseDto from(List<PetTraitCategoryResult> results) {
		return new PetTraitCategoryListResponseDto(
			results.stream()
				.map(PetTraitCategoryResponseDto::from)
				.toList()
		);
	}
}

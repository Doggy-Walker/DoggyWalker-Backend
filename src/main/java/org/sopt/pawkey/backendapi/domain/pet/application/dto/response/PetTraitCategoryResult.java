package org.sopt.pawkey.backendapi.domain.pet.application.dto.response;

import java.util.List;

import org.sopt.pawkey.backendapi.domain.pet.infra.persistence.entity.PetTraitCategoryEntity;


import java.util.List;

public record PetTraitCategoryResult(
	Long id,
	String name,
	List<PetTraitOptionResult> options
) {
	public record PetTraitOptionResult(
		Long id,
		String text
	) {}
}

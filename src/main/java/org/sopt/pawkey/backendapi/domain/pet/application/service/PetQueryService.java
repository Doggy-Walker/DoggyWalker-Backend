package org.sopt.pawkey.backendapi.domain.pet.application.service;

import java.util.List;

import org.sopt.pawkey.backendapi.domain.pet.application.dto.response.PetTraitCategoryResult;

public interface PetQueryService {
	List<PetTraitCategoryResult> getAllPetTraitCategories();

}

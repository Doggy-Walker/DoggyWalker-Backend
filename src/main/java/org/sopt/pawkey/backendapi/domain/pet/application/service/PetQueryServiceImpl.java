package org.sopt.pawkey.backendapi.domain.pet.application.service;

import java.util.List;

import org.sopt.pawkey.backendapi.domain.pet.application.dto.response.PetTraitCategoryResult;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PetQueryServiceImpl implements PetQueryService{
	@Override
	public List<PetTraitCategoryResult> getAllPetTraitCategories() {
		return List.of();
	}
}

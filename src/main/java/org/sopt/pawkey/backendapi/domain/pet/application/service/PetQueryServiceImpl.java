package org.sopt.pawkey.backendapi.domain.pet.application.service;

import java.util.List;

import org.sopt.pawkey.backendapi.domain.pet.application.dto.response.PetTraitCategoryResult;
import org.sopt.pawkey.backendapi.domain.pet.domain.model.PetTraitCategory;
import org.sopt.pawkey.backendapi.domain.pet.domain.repository.PetRepository;
import org.sopt.pawkey.backendapi.domain.pet.infra.mapper.PetTraitCategoryMapper;
import org.sopt.pawkey.backendapi.domain.pet.infra.persistence.entity.PetTraitCategoryEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PetQueryServiceImpl implements PetQueryService{

	private final PetRepository petRepository;
	@Override
	public List<PetTraitCategoryResult> getAllPetTraitCategories() {
		List<PetTraitCategory> domainList = petRepository.findAllPetTraitCategoriesWithOptions();

		List<PetTraitCategoryResult> results = domainList.stream()
			.map(PetTraitCategoryResult::fromDomain) // static fromDomain() 메서드 있다고 가정
			.toList();

		return results;
	}
}

package org.sopt.pawkey.backendapi.domain.pet.domain.repository;

import java.util.List;

import org.sopt.pawkey.backendapi.domain.pet.infra.persistence.entity.PetTraitCategoryEntity;

public interface PetRepository {

	List<PetTraitCategoryEntity> findAllPetTraitCategoriesWithOptions();
}

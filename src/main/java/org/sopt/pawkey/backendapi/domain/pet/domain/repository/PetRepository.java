package org.sopt.pawkey.backendapi.domain.pet.domain.repository;

import java.util.List;

import org.sopt.pawkey.backendapi.domain.pet.domain.model.Pet;
import org.sopt.pawkey.backendapi.domain.pet.infra.persistence.entity.PetTraitCategoryEntity;
import org.sopt.pawkey.backendapi.domain.user.domain.model.User;

public interface PetRepository {

	List<PetTraitCategoryEntity> findAllPetTraitCategoriesWithOptions();
}

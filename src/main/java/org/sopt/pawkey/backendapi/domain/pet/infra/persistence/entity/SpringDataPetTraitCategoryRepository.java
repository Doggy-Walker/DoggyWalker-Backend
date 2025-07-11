package org.sopt.pawkey.backendapi.domain.pet.infra.persistence.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SpringDataPetTraitCategoryRepository extends JpaRepository<PetTraitCategoryEntity, Long> {
	@Query("SELECT DISTINCT c FROM PetTraitCategoryEntity c " +
		"JOIN FETCH c.petTraitOptionEntityList")
	List<PetTraitCategoryEntity> findAllWithOptions();
}

package org.sopt.pawkey.backendapi.domain.pet.infra.mapper;

import org.sopt.pawkey.backendapi.domain.pet.domain.model.PetTraitSelected;
import org.sopt.pawkey.backendapi.domain.pet.infra.persistence.entity.PetTraitSelectedEntity;

public class PetTraitSelectedMapper {

	public static PetTraitSelected toDomain(PetTraitSelectedEntity entity) {
		if (entity == null) return null;

		return new PetTraitSelected(
			entity.getId(),
			PetMapper.toDomain(entity.getPet()),  // PetMapper 사용
			PetTraitOptionMapper.toDomain(entity.getPetTraitOption())
		);
	}

	public static PetTraitSelectedEntity toEntity(PetTraitSelected domain) {
		if (domain == null) return null;

		return PetTraitSelectedEntity.builder()
			.id(domain.getId())
			.pet(PetMapper.toEntity(domain.getPet())) // PetMapper 사용
			.petTraitOption(PetTraitOptionMapper.toEntity(domain.getPetTraitOption()))
			.build();
	}
}

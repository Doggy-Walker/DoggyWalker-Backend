package org.sopt.pawkey.backendapi.domain.pet.infra.mapper;

import org.sopt.pawkey.backendapi.domain.image.infra.mapper.ImageMapper;
import org.sopt.pawkey.backendapi.domain.pet.domain.model.Pet;
import org.sopt.pawkey.backendapi.domain.pet.infra.persistence.entity.PetEntity;
import org.sopt.pawkey.backendapi.domain.user.infra.mapper.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class PetMapper {

	public static Pet toDomain(PetEntity petEntity) {
		if (petEntity == null) return null;

		return new Pet(
			petEntity.getPetId(),
			petEntity.getName(),
			petEntity.getGender(),
			petEntity.getAge(),
			petEntity.isAgeKnown(),
			petEntity.isNeutered(),
			petEntity.getBreed(),
			ImageMapper.toDomain(petEntity.getProfileImage()),
			UserMapper.toDomain(petEntity.getUser()),
			petEntity.getPetTraitSelectedEntityList()
				.stream()
				.map(PetTraitSelectedMapper::toDomain)
				.toList()
		);
	}

	public static PetEntity toEntity(Pet pet) {
		if (pet == null) return null;

		return PetEntity.builder()
			.petId(pet.getPetId())
			.name(pet.getName())
			.gender(pet.getGender())
			.age(pet.getAge())
			.isAgeKnown(pet.isAgeKnown())
			.isNeutered(pet.isNeutered())
			.breed(pet.getBreed())
			.profileImage(ImageMapper.toEntity(pet.getProfileImage()))
			.user(UserMapper.toEntity(pet.getUser()))
			.petTraitSelectedEntityList(
				pet.getPetTraits().stream()
					.map(PetTraitSelectedMapper::toEntity)
					.toList())
			.build();
	}
}

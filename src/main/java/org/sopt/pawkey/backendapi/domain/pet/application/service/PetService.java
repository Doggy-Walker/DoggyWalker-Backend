package org.sopt.pawkey.backendapi.domain.pet.application.service;

import org.sopt.pawkey.backendapi.domain.pet.application.dto.request.CreatePetCommand;
import org.sopt.pawkey.backendapi.domain.pet.infra.persistence.entity.PetEntity;

public interface PetService {
	PetEntity createPet(final CreatePetCommand request);
}

// public interface UserService {
//
// 	User createUser(final CreateUserCommand request);
// }

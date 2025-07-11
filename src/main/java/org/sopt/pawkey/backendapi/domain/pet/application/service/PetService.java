package org.sopt.pawkey.backendapi.domain.pet.application.service;

import org.sopt.pawkey.backendapi.domain.pet.application.dto.request.CreatePetCommand;
import org.sopt.pawkey.backendapi.domain.pet.domain.model.Pet;

public interface PetService {
	Pet createPet(final CreatePetCommand request);
}


// public interface UserService {
//
// 	User createUser(final CreateUserCommand request);
// }

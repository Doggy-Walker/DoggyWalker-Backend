package org.sopt.pawkey.backendapi.domain.pet.application.service;

import org.sopt.pawkey.backendapi.domain.pet.application.dto.request.CreatePetCommand;
import org.sopt.pawkey.backendapi.domain.pet.domain.model.Pet;
import org.sopt.pawkey.backendapi.domain.user.application.dto.request.CreateUserCommand;
import org.sopt.pawkey.backendapi.domain.user.domain.model.User;

public interface PetService {
	Pet createPet(final CreatePetCommand request);
}


// public interface UserService {
//
// 	User createUser(final CreateUserCommand request);
// }

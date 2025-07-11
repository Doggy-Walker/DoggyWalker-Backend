package org.sopt.pawkey.backendapi.domain.pet.application.service;

import org.sopt.pawkey.backendapi.domain.pet.application.dto.request.CreatePetCommand;
import org.sopt.pawkey.backendapi.domain.pet.infra.persistence.entity.PetEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {

	@Override
	public PetEntity createPet(CreatePetCommand request) {
		// TODO: 실제 로직 구현
		return null;
	}
}

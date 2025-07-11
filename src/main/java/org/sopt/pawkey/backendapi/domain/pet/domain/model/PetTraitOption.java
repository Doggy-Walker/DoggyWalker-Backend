package org.sopt.pawkey.backendapi.domain.pet.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PetTraitOption {
	private final Long id;

	private PetTraitCategory petTraitCategory;
	private String optionText;
}

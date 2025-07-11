package org.sopt.pawkey.backendapi.domain.pet.domain.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PetTraitCategory {
	private final Long id;
	private String categoryName;
	private final List<PetTraitOption> petTraitOptionList;
}

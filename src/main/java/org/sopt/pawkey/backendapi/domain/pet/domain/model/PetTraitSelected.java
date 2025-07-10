package org.sopt.pawkey.backendapi.domain.pet.domain.model;

import java.awt.*;

import org.sopt.pawkey.backendapi.domain.user.domain.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PetTraitSelected {
	private final Long id;

	private Pet pet;
	private PetTraitOption petTraitOption;


}
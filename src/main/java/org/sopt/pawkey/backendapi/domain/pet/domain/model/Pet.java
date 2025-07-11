package org.sopt.pawkey.backendapi.domain.pet.domain.model;

import java.util.List;

import org.sopt.pawkey.backendapi.domain.image.domain.model.Image;
import org.sopt.pawkey.backendapi.domain.user.domain.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class Pet {
	private Long petId;
	private String name;
	private String gender;
	private int age;
	private boolean isAgeKnown;
	private boolean isNeutered;
	private String breed;

	private Image profileImage; // ← 여기가 중요!
	private User user;
	private List<PetTraitSelected> petTraits;
}

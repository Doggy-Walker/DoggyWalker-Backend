package org.sopt.pawkey.backendapi.domain.pet.domain.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import org.sopt.pawkey.backendapi.domain.image.infra.persistence.entity.ImageEntity;
import org.sopt.pawkey.backendapi.domain.pet.infra.persistence.entity.PetTraitSelectedEntity;
import org.sopt.pawkey.backendapi.domain.user.domain.model.User;
import org.sopt.pawkey.backendapi.domain.user.infra.persistence.entity.UserEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class Pet {

	private final Long petId;
	private final String name;
	private final String gender;
	private int age;
	private boolean isAgeKnown;
	private boolean isNeutered;
	private String breed;

	private Image profileImage; //도메인 Image로 수정하기
	private User user;
}

package org.sopt.pawkey.backendapi.domain.image.domain.model;

import java.util.List;

import org.sopt.pawkey.backendapi.domain.pet.domain.model.PetTraitSelected;
import org.sopt.pawkey.backendapi.domain.user.domain.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Image {
	private final Long imageId;
	private String url;
	private String extension;
	private int width;
	private int height;
}

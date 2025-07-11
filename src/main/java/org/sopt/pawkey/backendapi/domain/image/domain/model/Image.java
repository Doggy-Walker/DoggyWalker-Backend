package org.sopt.pawkey.backendapi.domain.image.domain.model;

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

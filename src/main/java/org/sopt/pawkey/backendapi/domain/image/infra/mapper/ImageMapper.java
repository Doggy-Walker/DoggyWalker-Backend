package org.sopt.pawkey.backendapi.domain.image.infra.mapper;

import org.sopt.pawkey.backendapi.domain.image.domain.model.Image;
import org.sopt.pawkey.backendapi.domain.image.infra.persistence.entity.ImageEntity;

public class ImageMapper {

	public static Image toDomain(ImageEntity entity) {
		if (entity == null) return null;

		return new Image(
			entity.getImageId(),
			entity.getImageUrl(),
			entity.getExtension(),
			entity.getWidth(),
			entity.getHeight()
		);
	}

	public static ImageEntity toEntity(Image domain) {
		if (domain == null) return null;

		return ImageEntity.builder()
			.imageId(domain.getImageId())
			.imageUrl(domain.getUrl())
			.extension(domain.getExtension())
			.width(domain.getWidth())
			.height(domain.getHeight())
			.build();
	}
}

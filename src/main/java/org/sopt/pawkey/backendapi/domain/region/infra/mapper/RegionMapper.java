package org.sopt.pawkey.backendapi.domain.region.infra.mapper;

import org.sopt.pawkey.backendapi.domain.region.domain.model.Region;
import org.sopt.pawkey.backendapi.domain.region.infra.persistence.entity.RegionEntity;
import org.springframework.stereotype.Component;

@Component
public class RegionMapper {

	public static Region toDomain(RegionEntity entity) {
		if (entity == null) return null;

		return new Region(
			entity.getRegionId(),
			entity.getRegionName(),
			entity.getRegionType(),
			entity.getParent() != null ? entity.getParent().getRegionId() : null
		);
	}

	public static RegionEntity toEntity(Region domain) {
		if (domain == null) return null;

		return RegionEntity.builder()
			.regionId(domain.getRegionId())
			.regionName(domain.getRegionName())
			.regionType(domain.getRegionType())
			.build();
	}
}

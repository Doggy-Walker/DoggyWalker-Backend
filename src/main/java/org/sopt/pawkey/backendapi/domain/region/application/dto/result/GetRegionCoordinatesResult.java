package org.sopt.pawkey.backendapi.domain.region.application.dto.result;

import java.util.Map;

import org.sopt.pawkey.backendapi.domain.region.infra.persistence.entity.RegionEntity;

import lombok.Builder;

@Builder
public record GetRegionCoordinatesResult(
	String regionName,
	Map<String, Object> geometryDto
) {
	public static GetRegionCoordinatesResult from(RegionEntity region) {

		return GetRegionCoordinatesResult.builder()
			.regionName(region.getFullRegionName())
			.geometryDto(region.getGeoJson())
			.build();
	}

}

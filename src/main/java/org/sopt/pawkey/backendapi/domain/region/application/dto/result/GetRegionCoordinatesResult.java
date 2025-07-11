package org.sopt.pawkey.backendapi.domain.region.application.dto.result;

import java.util.Map;

import org.sopt.pawkey.backendapi.domain.region.domain.model.Region;

import lombok.Builder;

@Builder
public record GetRegionCoordinatesResult(
	String regionName,
	Map<String, Object> geometryDto
) {
	public static GetRegionCoordinatesResult from(Region region) {

		return GetRegionCoordinatesResult.builder()
			.regionName(region.getFullRegionName())
			.geometryDto(region.getArea().getGeoJson())
			.build();
	}
}

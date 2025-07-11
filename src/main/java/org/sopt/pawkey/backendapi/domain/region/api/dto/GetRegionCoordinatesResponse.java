package org.sopt.pawkey.backendapi.domain.region.api.dto;

import java.util.Map;

import org.sopt.pawkey.backendapi.domain.region.application.dto.result.GetRegionCoordinatesResult;

import lombok.Builder;

@Builder
public record GetRegionCoordinatesResponse(
	String regionName,
	Map<String, Object> geometryDto
) {
	public static GetRegionCoordinatesResponse from(GetRegionCoordinatesResult result) {
		return GetRegionCoordinatesResponse.builder()
			.regionName(result.regionName())
			.geometryDto(result.geometryDto())
			.build();
	}
}

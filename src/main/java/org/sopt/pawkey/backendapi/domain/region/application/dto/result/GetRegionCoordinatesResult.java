package org.sopt.pawkey.backendapi.domain.region.application.dto.result;

import java.util.Map;
import java.util.Optional;

import org.sopt.pawkey.backendapi.domain.region.domain.model.Region;
import org.sopt.pawkey.backendapi.domain.common.util.GeoJsonUtil;

import lombok.Builder;

@Builder
public record GetRegionCoordinatesResult(
	String regionName,
	Map<String, Object> geometryDto
) {
	public static GetRegionCoordinatesResult from(Region region) {
		// MultiPolygon 객체를 GeoJSON 문자열로 변환
		Map<String, Object> geoJson = GeoJsonUtil.toGeoJson(region.getAreaGeometry());

		String parentText = region.getParent() == null ? "" : region.getParent().getRegionName() + " ";

		return GetRegionCoordinatesResult.builder()
			.regionName(parentText + region.getRegionName())
			.geometryDto(geoJson)
			.build();
	}
}

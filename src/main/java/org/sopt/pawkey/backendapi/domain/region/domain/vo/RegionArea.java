package org.sopt.pawkey.backendapi.domain.region.domain.vo;

import java.util.Map;

import org.locationtech.jts.geom.MultiPolygon;
import org.sopt.pawkey.backendapi.domain.common.util.GeoJsonUtil;

import lombok.Value;

/**
 * Region의 영역(면적) 정보를 표현하는 VO
 */
@Value
public class RegionArea {
	MultiPolygon multiPolygon;

	private RegionArea(MultiPolygon multiPolygon) {
		this.multiPolygon = multiPolygon;
	}

	public static RegionArea of(MultiPolygon areaGeometry) {
		return new RegionArea(areaGeometry);
	}

	@Override
	public String toString() {
		return "RegionArea{area=" + multiPolygon.getArea() + "}";
	}

	public Map<String, Object> getGeoJson() {
		return GeoJsonUtil.toGeoJson(multiPolygon);
	}
}